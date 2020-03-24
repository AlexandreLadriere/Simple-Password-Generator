import javax.swing.*;

/**
 * Implements the password generator application
 */
public class PasswordGenerator extends JFrame {

    public PasswordGenerator() {
        super("Password generator - Alexandre Ladrière - 2020");
        setResizable(false);
        PasswordGeneratorModel pwdGenerator = new PasswordGeneratorModel();
        Gui gui = new Gui(pwdGenerator);
        setContentPane(gui);
        this.setSize(450, 400);
        // pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PasswordGenerator();
    }
}
