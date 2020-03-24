import javax.swing.*;

public class PasswordGenerator extends JFrame {

    public PasswordGenerator() {
        super("Password generator - Alexandre Ladrière - 2020");
        PasswordGeneratorModel pwdGenerator = new PasswordGeneratorModel();
        Gui gui = new Gui(pwdGenerator);
        setContentPane(gui);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PasswordGenerator();
    }
}
