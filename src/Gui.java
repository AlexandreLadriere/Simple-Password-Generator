import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel {
    private JTextField passwordTextField;
    private JTextField pwdLengthTextField;
    private JButton generatePwdButton;
    private JCheckBox upperCaseCheckBox;
    private JCheckBox lowerCaseCheckBox;
    private JCheckBox numbersCheckBox;
    private JCheckBox specialCharactersCheckBox;

    private PasswordGenerator pwdGenerator;

    public Gui(PasswordGenerator pwdGenerator) {
        this.pwdGenerator = pwdGenerator;
        this.setLayout(new BorderLayout());

        // North
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        // Center
        JPanel mainCenterPanel = new JPanel();
        mainCenterPanel.setLayout(new BorderLayout());
        // North
        passwordTextField = new JTextField();
        mainCenterPanel.add(passwordTextField, BorderLayout.NORTH);
        // Center
        JPanel mainCenterCenterPanel = new JPanel();
        mainCenterCenterPanel.setLayout(new BoxLayout(mainCenterCenterPanel, BoxLayout.Y_AXIS));
        upperCaseCheckBox = new JCheckBox("Include uppercase letters");
        lowerCaseCheckBox = new JCheckBox("Include lowercase letters");
        numbersCheckBox = new JCheckBox("Include numbers");
        specialCharactersCheckBox = new JCheckBox("Include symbols");
        mainCenterCenterPanel.add(upperCaseCheckBox);
        mainCenterCenterPanel.add(lowerCaseCheckBox);
        mainCenterCenterPanel.add(numbersCheckBox);
        mainCenterCenterPanel.add(specialCharactersCheckBox);
        mainCenterPanel.add(mainCenterCenterPanel, BorderLayout.CENTER);
        // South
        JPanel mainCenterSouthPanel = new JPanel();
        mainCenterSouthPanel.setLayout(new FlowLayout());
        JLabel pwdLengthLabel = new JLabel("Password length");
        pwdLengthTextField = new JTextField("20");
        mainCenterSouthPanel.add(pwdLengthLabel);
        mainCenterSouthPanel.add(pwdLengthTextField);
        mainCenterPanel.add(mainCenterSouthPanel, BorderLayout.SOUTH);
        this.add(mainCenterPanel, BorderLayout.CENTER);
        // South
        generatePwdButton = new JButton("Generate password");
        generatePwdButton.addActionListener(new Controller(this));
        generatePwdButton.setHorizontalAlignment(JLabel.CENTER);
        this.add(generatePwdButton, BorderLayout.SOUTH);
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

    public PasswordGenerator getPwdGenerator() {
        return pwdGenerator;
    }
}
