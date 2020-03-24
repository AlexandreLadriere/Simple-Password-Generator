import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Gui extends JPanel {
    private JTextField passwordTextField;
    private JTextField pwdLengthTextField;
    private JButton generatePwdButton;
    private JCheckBox upperCaseCheckBox;
    private JCheckBox lowerCaseCheckBox;
    private JCheckBox numbersCheckBox;
    private JCheckBox specialCharactersCheckBox;

    private PasswordGeneratorModel pwdGenerator;

    private static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 22);
    private static final Font FONT_BUTTON = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    private static final Color MAIN_COLOR = new Color(35, 35, 91);
    private static final Color MAIN_COLOR_DARK = new Color(21, 21, 55);
    private static final Color MAIN_COLOR_LIGHT = new Color(59, 59, 152);
    private static final Color TEXT_COLOR = new Color(255, 255, 255);

    public Gui(PasswordGeneratorModel pwdGenerator) {
        this.pwdGenerator = pwdGenerator;
        this.setLayout(new BorderLayout());
        this.setBackground(MAIN_COLOR);

        // North
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(FONT_TITLE);
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setBackground(MAIN_COLOR);
        this.add(titleLabel, BorderLayout.NORTH);

        // Center
        JPanel mainCenterPanel = new JPanel();
        mainCenterPanel.setLayout(new BorderLayout());
        mainCenterPanel.setBackground(MAIN_COLOR);
        // Center - North
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(MAIN_COLOR);
        northPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        passwordTextField = new JTextField();
        passwordTextField.setBorder(new EmptyBorder(10, 10, 10, 10));
        passwordTextField.setHorizontalAlignment(JTextField.CENTER);
        passwordTextField.setFont(FONT);
        passwordTextField.setBackground(MAIN_COLOR_DARK);
        passwordTextField.setForeground(TEXT_COLOR);
        northPanel.add(passwordTextField, BorderLayout.CENTER);
        mainCenterPanel.add(northPanel, BorderLayout.NORTH);
        // Center - Center
        JPanel mainCenterCenterPanel = new JPanel();
        mainCenterCenterPanel.setLayout(new GridLayout(4, 1));
        mainCenterCenterPanel.setBackground(MAIN_COLOR);
        upperCaseCheckBox = new JCheckBox("Include uppercase letters");
        initCheckBoxDesign(upperCaseCheckBox);
        lowerCaseCheckBox = new JCheckBox("Include lowercase letters");
        initCheckBoxDesign(lowerCaseCheckBox);
        numbersCheckBox = new JCheckBox("Include numbers");
        initCheckBoxDesign(numbersCheckBox);
        specialCharactersCheckBox = new JCheckBox("Include symbols");
        initCheckBoxDesign(specialCharactersCheckBox);
        mainCenterCenterPanel.add(upperCaseCheckBox);
        mainCenterCenterPanel.add(lowerCaseCheckBox);
        mainCenterCenterPanel.add(numbersCheckBox);
        mainCenterCenterPanel.add(specialCharactersCheckBox);
        mainCenterPanel.add(mainCenterCenterPanel, BorderLayout.CENTER);
        // Center - South
        JPanel mainCenterSouthPanel = new JPanel();
        mainCenterSouthPanel.setLayout(new FlowLayout());
        mainCenterSouthPanel.setBackground(MAIN_COLOR);
        mainCenterSouthPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel pwdLengthLabel = new JLabel("Password length");
        pwdLengthLabel.setFont(FONT);
        pwdLengthLabel.setForeground(TEXT_COLOR);
        pwdLengthTextField = new JTextField("20");
        pwdLengthTextField.setFont(FONT);
        mainCenterSouthPanel.add(pwdLengthLabel);
        mainCenterSouthPanel.add(pwdLengthTextField);
        mainCenterPanel.add(mainCenterSouthPanel, BorderLayout.SOUTH);
        this.add(mainCenterPanel, BorderLayout.CENTER);
        // South
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        generatePwdButton = new JButton("Generate password");
        generatePwdButton.addActionListener(new Controller(this));
        generatePwdButton.setHorizontalAlignment(JLabel.CENTER);
        generatePwdButton.setFont(FONT_BUTTON);
        generatePwdButton.setForeground(TEXT_COLOR);
        generatePwdButton.setBackground(MAIN_COLOR_LIGHT);
        generatePwdButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        southPanel.add(generatePwdButton, BorderLayout.CENTER);
        this.add(generatePwdButton, BorderLayout.SOUTH);
    }

    private void initCheckBoxDesign(JCheckBox checkBox) {
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
        checkBox.setFont(FONT);
        checkBox.setForeground(TEXT_COLOR);
        checkBox.setBackground(MAIN_COLOR);
        checkBox.setBorder(new EmptyBorder(10, 20, 10, 20));
    }

    public JButton getGeneratePwdButton() {
        return generatePwdButton;
    }

    public JCheckBox getUpperCaseCheckBox() {
        return upperCaseCheckBox;
    }

    public JCheckBox getLowerCaseCheckBox() {
        return lowerCaseCheckBox;
    }

    public JCheckBox getNumbersCheckBox() {
        return numbersCheckBox;
    }

    public JCheckBox getSpecialCharactersCheckBox() {
        return specialCharactersCheckBox;
    }

    public JTextField getPwdLengthTextField() {
        return pwdLengthTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public PasswordGeneratorModel getPwdGenerator() {
        return pwdGenerator;
    }
}
