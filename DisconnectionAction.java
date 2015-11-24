import javax.swing.*;
import java.awt.event.ActionEvent;

public class DisconnectionAction extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
        Interface.ipLabel.setText("Disconnected");
        Interface.ipButton.setText("Connect");
        Interface.textArea.setText("");
        Interface.ipField.setText("");
        Interface.ipButton.removeActionListener(this);
        Interface.ipButton.addActionListener(new ConnectionAction());
    }
}
