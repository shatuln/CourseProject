import javax.swing.*;
import java.awt.event.ActionEvent;

public class historyButAction extends AbstractAction{

    public void actionPerformed(ActionEvent ev) {
        Interface.textArea.setText(TextFile.read());
        Interface.historyButton.setText("Chat");
        Interface.button.setText("Find");
        Interface.textField.setText("");
        Interface.status.setText("To search, type something and press the button");

        Interface.button.removeActionListener(Interface.textListener);
        Interface.textField.removeActionListener(Interface.textListener);
        Interface.button.addActionListener(Interface.textListener = new Finder());
        Interface.textField.addActionListener(Interface.textListener);


        Interface.historyButton.removeActionListener(this);
        Interface.historyButton.addActionListener(new chatButAction());

    }
}
