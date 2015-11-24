import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import static javax.swing.GroupLayout.Alignment.*;

public class Interface extends JFrame {
    public static JLabel ipLabel;
    public JLabel label;
    public static JTextField textField;
    public static JTextArea textArea;
    public static JButton button;
    public JScrollPane scrollPane;
    public static JTextField ipField;
    public static JButton ipButton;
    public static JButton historyButton;
    public static JLabel status;
    public static Highlighter hilit;
    public static Highlighter.HighlightPainter painter;

    public static ActionListener buttonListener, textListener;

    public Interface() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        status = new JLabel("Connect to somebody");

        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

        label = new JLabel("Connect to ip");
        ipLabel = new JLabel("Disconnected");

        textField = new JTextField(5);
        textField.addActionListener(textListener = new TextAction());

        ipField = new JTextField(5);

        ipButton = new JButton("Connect");
        ipButton.addActionListener(new ConnectionAction());

        historyButton = new JButton("History");
        historyButton.addActionListener(new historyButAction());

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setHighlighter(hilit);

        button = new JButton("Send");
        button.addActionListener(textListener);

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
                                .addComponent(ipButton)
                                .addComponent(ipLabel)
                                .addComponent(historyButton))

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
                                .addComponent(button)
                                .addComponent(historyButton))
                        .addComponent(status)
        );


        setTitle("P2P chat");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
