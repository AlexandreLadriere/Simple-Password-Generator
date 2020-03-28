import java.security.SecureRandom;

/**
 * Implements a simple password generator
 */
public class PasswordGeneratorModel {

    /**
     * Generates a password according to the given parameters
     *
     * @param length               Length of the password
     * @param hasNumbers           Boolean to indicate if the password must contains numbers or not
     * @param hasUpperCaseLetters  Boolean to indicate if the password must contains upper case letters or not
     * @param hasLowerCaseLetters  Boolean to indicate if the password must contains lower case letters or not
     * @param hasSpecialCharacters Boolean to indicate if the password must contains special characters or not
     * @return Password in string format
     */
    public String generate(Integer length, Boolean hasNumbers, Boolean hasUpperCaseLetters, Boolean hasLowerCaseLetters, Boolean hasSpecialCharacters) {
        String usedCharacters = "";
        if (hasNumbers) {
            usedCharacters += Constants.numbers;
        }
        if (hasSpecialCharacters) {
            usedCharacters += Constants.specialCharacters;
        }
        if (hasLowerCaseLetters) {
            usedCharacters += Constants.lowerCaseLetters;
        }
        if (hasUpperCaseLetters) {
            usedCharacters += Constants.upperCaseLetters;
        }
        if (!hasLowerCaseLetters && !hasUpperCaseLetters && !hasNumbers && !hasSpecialCharacters) {
            return "";
        }
        if (length <= 0) {
            return "";
        }
        char[] password = new char[length];
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            password[i] = usedCharacters.charAt(random.nextInt(usedCharacters.length()));
        }

        return charArrayToString(password);
    }

    /**
     * Converts a char array to a string. For example ['h', 'e', 'l', 'l', 'o'] will become "hello"
     *
     * @param charArray The char array you want to convert to a string
     * @return String representation of the content of the given char array
     */
    private String charArrayToString(char[] charArray) {
        StringBuilder string = new StringBuilder();
        for (char c : charArray) {
            string.append(c);
        }
        return string.toString();
    }
}
