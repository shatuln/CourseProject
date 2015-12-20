import javax.swing.*;
import java.awt.event.ActionEvent;


public class chatButAction extends AbstractAction{

    public void actionPerformed(ActionEvent ev) {
        Interface.textArea.setText("");
        Interface.textField.setText("");
        Interface.historyButton.setText("History");
        Interface.button.setText("Send");
        Interface.status.setText("Connect to somebody");

        Interface.historyButton.removeActionListener(this);
        Interface.historyButton.addActionListener(new historyButAction());

        Interface.button.removeActionListener(Interface.textListener);
        Interface.textField.removeActionListener(Interface.textListener);
        Interface.button.addActionListener(Interface.textListener = new TextAction());
        Interface.textField.addActionListener(Interface.textListener);

    }
}
