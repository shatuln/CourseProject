import java.awt.event.ActionEvent;
import javax.swing.*;

public class TextAction extends AbstractAction {
    public void actionPerformed(ActionEvent evt) {
        String text = Interface.textField.getText();
        Interface.textArea.append("You: " + text + "\n");
        Interface.textField.setText("");

    }
}
