import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

public class Interface extends JFrame {
    public static JLabel ipLabel;
    public JLabel label;
    public static JTextField textField;
    public static JTextArea textArea;
    public JButton button;
    public JScrollPane scrollPane;
    public static JTextField ipField;
    public static JButton ipButton;

    public Interface() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        label = new JLabel("Connect to ip");
        ipLabel = new JLabel("Disconnected");

        textField = new JTextField(5);
        textField.addActionListener(new TextAction());

        ipField = new JTextField(5);

        ipButton = new JButton("Connect");
        ipButton.addActionListener(new ConnectionAction());

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        button = new JButton("Send");
        button.addActionListener(new TextAction());

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
            public void windowClosing(WindowEvent event) {
                TextFile.update("===============End of session==============");
                System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) {

            }
            @Override
            public void windowIconified(WindowEvent e) {

            }
            @Override
            public void windowDeiconified(WindowEvent e) {

            }
            @Override
            public void windowActivated(WindowEvent e) {

            }
            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

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
                                .addComponent(label)
                                .addComponent(ipField, 100, 100, 100)
                                .addComponent(ipButton)
                                .addComponent(ipLabel))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(scrollPane)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(label)
                                        .addComponent(ipField, 20, 20, 20)
                                        .addComponent(ipButton)
                                        .addComponent(ipLabel)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField)
                                .addComponent(button))
        );


        setTitle("P2P chat");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
