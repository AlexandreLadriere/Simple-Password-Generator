#!/bin/bash

# Paths
SRC_PATH="src/"
OUT_PATH="out/"

# Commands
BUILD="build"
BUILD_DESC="Build all .class files"
RUN="run"
RUN_DESC="Run the main .class file"
BUILD_JAR="build-jar"
BUILD_JAR_DESC="Build the JAR file"
CLEAN="clean"
CLEAN_DESC="Clean the current repository from all created files"

# File list
declare -a CLASSES=(
  "Constants.java"
  "PasswordGeneratorModel.java"
  "Gui.java"
  "Controller.java"
  "PasswordGenerator.java"
)

# Main class name (without extension)
MAIN="PasswordGenerator"

function build() {
  # Builds all .class files which are in the $CLASSES array into the $OUT_PATH folder
  echo "Building .class files..."
  mkdir -p $OUT_PATH
	cd $SRC_PATH || exit
  for i in "${CLASSES[@]}"
  do
    echo "javac -d $OUT_PATH ""$i"""
    javac -d ../${OUT_PATH} "$i"
  done
  cd ..
  echo "All .class files have been built !"
}

function run() {
  # Runs the $MAIN class
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists
    echo "$OUT_PATH does not exist"
    build
  fi
  if [ ! -f "${OUT_PATH}${MAIN}.class" ]; then # checks if $MAIN.class file exists
    echo "${MAIN}.class does not exist"
    build
  fi
  echo "Running $MAIN..."
  cd $OUT_PATH || exit
  java $MAIN
  cd ..
  exit
}

function build_jar() {
  # Builds the .jar file
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists
    echo "$OUT_PATH does not exist"
    build
  fi
  if [ ! -f "${OUT_PATH}${MAIN}.class" ]; then # checks if $MAIN.class file exists
    echo "${MAIN}.class does not exist"
    build
  fi
  cd $OUT_PATH || exit
  jar cfe ${MAIN}.jar $MAIN ./*class
  mv -v ${MAIN}.jar ./../
  cd ..
  echo "JAR file created"
  exit
}

function clean() {
  # Removes the $OUT_PATH folder
  echo "Cleaning folder..."
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists]
    echo "Nothing to clean"
  else
    rm -r $OUT_PATH
    rm ${MAIN}.jar
    echo "Folder cleaned"
    exit
  fi
  exit
}

function help() {
  echo "You have to give only one arguments to this script. These are the allowed arguments:"
  echo "$BUILD      ->     $BUILD_DESC"
  echo "$RUN        ->     $RUN_DESC"
  echo "$BUILD_JAR  ->     $BUILD_JAR_DESC"
  echo "$CLEAN      ->     $CLEAN_DESC"
  exit
}

### Main body ###
if [ "$1" == $BUILD ]; then
  build
  exit
fi

if [ "$1" == $RUN ]; then
  run
fi

if [ "$1" == $CLEAN ]; then
  clean
fi

if [ "$1" == $BUILD_JAR ]; then
  build_jar
fi

# if the command is not recognized (if the command is recognized, we never reach this point)
echo "Argument not recognized"
help
