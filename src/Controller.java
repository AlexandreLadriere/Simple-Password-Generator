import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
        if (cmd.equals(gui.getCopyButton())) {
            String pwd = gui.getPasswordTextField().getText();
            StringSelection stringSelection = new StringSelection(pwd);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
}
