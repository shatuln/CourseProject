import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class TextAction extends AbstractAction {
    public void actionPerformed(ActionEvent evt) {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
        String text = Interface.textField.getText();
        StringBuilder sb = new StringBuilder();
        text = text + "\r\n";
        sb.append("[");
        sb.append(format1.format(d));
        sb.append(" | You]: ");
        sb.append(text);
        Interface.textArea.append("You: " + text);
        TextFile.update(sb.toString());
        Interface.textField.setText("");

    }
}
