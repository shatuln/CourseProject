import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

public class Interface extends JFrame implements ActionListener {
    public JTextField textField;
    public JTextArea textArea;
    public JButton button;
    public JScrollPane scrollPane;
    public static JTextField ipField;
    public JButton ipButton;
    private final static String newline = "\n";

    public Interface() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        textField = new JTextField(5);
        textField.addActionListener(this);

        ipField = new JTextField(5);

        ipButton = new JButton("Connect");
        ipButton.addActionListener(new ConnectionAction());

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        button = new JButton("Send");
        button.addActionListener(this);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(scrollPane))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField)
                                        .addComponent(button)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(ipField, 100, 100, 100)
                                .addComponent(ipButton))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(scrollPane)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ipField, 20, 20, 20)
                                    .addComponent(ipButton)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField)
                                .addComponent(button))
        );


        setTitle("yo");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.setText("");

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
//        textArea.setCaretPosition(textArea.getDocument().getLength());
    }


}
