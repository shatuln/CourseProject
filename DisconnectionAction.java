import javax.swing.*;
import java.awt.event.ActionEvent;

public class DisconnectionAction extends AbstractAction {

    public static void disconnection() {
        Interface.ipLabel.setText("Disconnected");
        Interface.ipButton.setText("Connect");
        //Interface.textArea.setText("");
        if (Interface.textListener instanceof TextAction) {
            Interface.textArea.append("Connection closed" + "\n");
        }
        Interface.ipField.setText("");
        Interface.portField.setText("");
        Interface.ipButton.removeActionListener(Interface.connectListener);
        Interface.ipButton.addActionListener(Interface.connectListener = new ConnectionAction());

    }

    public void actionPerformed(ActionEvent ev) {

        Interface.cli.getMessage("//disable");
        Interface.clientFlag = false;
        TextAction.online = false;
        Interface.serv.connection = false;

        Interface.ipLabel.setText("Disconnected");
        Interface.ipButton.setText("Connect");
        //Interface.textArea.setText("");
//        if (Interface.textListener instanceof TextAction) {
//            Interface.textArea.append("Connection closed" + "\n");
//        }
        Interface.ipField.setText("");
        Interface.portField.setText("");
        Interface.ipButton.removeActionListener(Interface.connectListener);
        Interface.ipButton.addActionListener(Interface.connectListener = new ConnectionAction());
    }
}
