import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import static javax.swing.GroupLayout.Alignment.*;

public class Interface extends JFrame {
    public static boolean clientFlag = false;

    public static JLabel ipLabel;
    public JLabel label, label1;
    public static JTextField textField;
    public static JTextArea textArea;
    public static JButton button;
    public JScrollPane scrollPane;
    public static JTextField ipField, portField;
    public static JButton ipButton;
    public static JButton historyButton;
    public static JLabel status, connectionStatus, connectionStatus1;
    public static Highlighter hilit;
    public static Highlighter.HighlightPainter painter;

    public static Client cli;
    public static Server serv;

    public static ActionListener connectListener, textListener;

    public Interface() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);


        status = new JLabel("Connect to somebody");

        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

        label = new JLabel("Connect to ip");
        label1 = new JLabel("and port");
        connectionStatus = new JLabel("");
        connectionStatus1 = new JLabel("");
        ipLabel = new JLabel("Disconnected");

        textField = new JTextField(5);
        textField.addActionListener(textListener = new TextAction());

        ipField = new JTextField(5);
        portField = new JTextField(5);

        ipButton = new JButton("Connect");
        ipButton.addActionListener(connectListener = new ConnectionAction());

        historyButton = new JButton("History");
        historyButton.addActionListener(new historyButAction());

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setHighlighter(hilit);

        button = new JButton("Send");
        button.addActionListener(textListener);

        serv = new Server(4000);                        //server
        serv.start();

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
                                        .addComponent(button))
                                .addComponent(status))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(label)
                                .addComponent(ipField, 100, 100, 100)
                                .addComponent(label1)
                                .addComponent(portField, 100, 100, 100)
                                .addComponent(ipButton)
                                .addComponent(ipLabel)
                                .addComponent(historyButton)
                                .addComponent(connectionStatus)
                                .addComponent(connectionStatus1))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(scrollPane)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(label)
                                        .addComponent(ipField, 20, 20, 20)
                                        .addComponent(label1)
                                        .addComponent(portField, 20, 20, 20)
                                        .addComponent(ipButton)
                                        .addComponent(ipLabel)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField)
                                .addComponent(button)
                                .addComponent(historyButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(status)
                                .addComponent(connectionStatus))
                        .addComponent(connectionStatus1)

        );


        setTitle("P2P chat");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
