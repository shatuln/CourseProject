import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionAction extends AbstractAction{

        public boolean validateip(String ip){
            Pattern pattern;
            Matcher matcher;

            final String IPADDRESS_PATTERN =
                    "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
            pattern = Pattern.compile(IPADDRESS_PATTERN);
            matcher = pattern.matcher(ip);
            return matcher.matches();
        }



    public static void connection() {
        Interface.ipButton.setText("Disconnect");
        Interface.textArea.setText("");

        Interface.ipButton.removeActionListener(Interface.connectListener);
        Interface.ipButton.addActionListener(Interface.connectListener = new DisconnectionAction());
    }


    public void actionPerformed(ActionEvent ev) {
        String ipfield = Interface.ipField.getText();
        if (validateip(ipfield)) {
            Interface.cli = new Client(ipfield, Interface.portField.getText());
            Interface.cli.start();
            try {Thread.sleep(1000);} catch (Exception e) {}
            String pf = String.valueOf(Interface.serv.port);
            try {Interface.cli.getMessage(Interface.cli.s.getInetAddress().getLocalHost().getHostAddress());} catch (Exception e) {}
            Interface.cli.getMessage(pf);

            String ip = Interface.ipField.getText();
            System.out.println(ip);
            connection();
        } else {
            //Interface.textArea.append("IP is not valid" + "\n");
            Interface.status.setText("IP is not valid");
        }

    }

}
