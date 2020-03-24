import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the interface controller
 */
public class Controller implements ActionListener {
    private Gui gui;

    public Controller(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object cmd = e.getSource();
        if (cmd.equals(gui.getGeneratePwdButton())) {
            try {
                Integer pwdLength = Integer.parseInt(gui.getPwdLengthTextField().getText());
                gui.getPasswordTextField().setText(gui.getPwdGenerator().generate(pwdLength, gui.getNumbersCheckBox().isSelected(), gui.getUpperCaseCheckBox().isSelected(), gui.getLowerCaseCheckBox().isSelected(), gui.getSpecialCharactersCheckBox().isSelected()));
            } catch (NumberFormatException ex) {
                gui.getPasswordTextField().setText(gui.getPwdGenerator().generate(0, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
            }
        }
    }
}
