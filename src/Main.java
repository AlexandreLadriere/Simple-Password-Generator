import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        super("Password generator - Alexandre Ladrière - 2020");
        PasswordGenerator pwdGenerator = new PasswordGenerator();
        Gui gui = new Gui(pwdGenerator);
        setContentPane(gui);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}
