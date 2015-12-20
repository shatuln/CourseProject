import java.awt.event.ActionEvent;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class TextAction extends AbstractAction {

    public static boolean online = false;

    public void actionPerformed(ActionEvent evt) {
        if (online) {
            Date d = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
            String text = Interface.textField.getText();
            Interface.cli.getMessage(text);
            text = text + "\r\n";
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(format1.format(d));
            sb.append(" | You]: ");
            sb.append(text);
            Interface.textArea.append("You: " + text);
            TextFile.update(sb.toString());
            Interface.textField.setText("");
        } else {
            Interface.textArea.append("No connection" + "\n");
        }



    }
}
