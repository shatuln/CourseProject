import javax.swing.*;
import java.awt.event.*;

public class ConnectionAction extends AbstractAction{
    public void actionPerformed(ActionEvent ev) {
        String ip = Interface.ipField.getText();
        System.out.println(ip);
        Interface.ipLabel.setText("Connected");
//        Interface.textArea.setText(TextFile.read());
        TextFile.update("//Connected to " + ip);
        Interface.ipButton.setText("Disconnect");
        Interface.ipButton.removeActionListener(this);
        Interface.ipButton.addActionListener(new DisconnectionAction());
    }

}
