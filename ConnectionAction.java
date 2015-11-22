import javax.swing.*;
import java.awt.event.*;

public class ConnectionAction extends AbstractAction{
    public void actionPerformed(ActionEvent ev) {
        String ip = Interface.ipField.getText();
        System.out.println(ip);
        Interface.ipLabel.setText("Connected");

    }

}
