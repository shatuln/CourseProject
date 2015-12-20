import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Finder extends AbstractAction {

    private static String content;
    private static int fullIndex = 0;

    public void actionPerformed(ActionEvent evt) {

        findText(Interface.textField.getText());

    }

    public static void findText(String c){

        if (c.equals("")) {
            Interface.status.setText("Nothing to search");
        } else {

            if (!c.equals(content)) {
                fullIndex = 0;
                Interface.hilit.removeAllHighlights();
            }

            content = c;


            int r = read();
            if (r != -1) {
                int end = r + content.length();
                try {
                    Interface.hilit.addHighlight(r, end, Interface.painter);
                } catch (BadLocationException e) {
                }
                Interface.textArea.setCaretPosition(end);
                fullIndex = end;
            } else {
                fullIndex = 0;
            }


        }
    }

    public static int read() {

        String str;
        int len, allIndex = fullIndex, index;

        try {
            BufferedReader in = new BufferedReader(new FileReader(TextFile.file.getAbsoluteFile()));
            in.skip(fullIndex);

            while ((str = in.readLine()) != null) {
                len = str.length();
                str = str.replaceAll("\\/\\/Connected to [0-9.]*", "");
                str = str.replaceAll("===============End of session==============", "");
                str = str.replaceAll("\\[.*\\]:\\s", "");
                index = str.indexOf(content, 0);
                if (index != -1) {
                    allIndex = allIndex + index + 29;
                    Interface.status.setText("Press the button to find next");
                    return allIndex;
                } else {
                    allIndex = allIndex + len + 2;
                }

            }


        } catch(IOException e) {
            throw new RuntimeException(e);
        }


        Interface.status.setText("End of file");
        return -1;
    }

}
