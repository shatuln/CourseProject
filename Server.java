import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Server extends Thread
{
    int port;
    ServerSocket server;
    String ipadress;
    private Socket s;
    boolean flag, connection;
    private String str, sadr, sport;
    private Reader r;
    private BufferedReader buf;


    Server(int p) {
        this.port = p;
    }

    public void checkFlag() {
        try {
            if (!Interface.clientFlag) {
                sadr = buf.readLine();
                sport = buf.readLine();
                Interface.status.setText("You are with stranger from " + sadr);
                Interface.cli = new Client(sadr, sport);
                Interface.cli.start();
                try {Thread.sleep(100);} catch (Exception e) {}
                Interface.cli.getMessage(ipadress);
            } else {
                //socket = s.getInetAddress();
                //sadr = socket.toString().substring(1);
                sadr = buf.readLine();
                Interface.status.setText("You are with stranger from " + sadr);
            }
        } catch (Exception e) {}
    }

    public void run() {
        int i = 0;



        try {

            while (!flag) {

                try {
                    server = new ServerSocket(port);
                    Interface.connectionStatus.setText("You are available");
                    Interface.connectionStatus1.setText("on port " + port);
                    System.out.println(server);
                    //System.out.println(server.getLocalPort());
                    flag = true;
                } catch (BindException e) {
                    port = port + 1;
                }
            }
            ipadress = server.getInetAddress().getLocalHost().getHostAddress();
            Interface.yourIp.setText("Your IP is " + ipadress);
            s = server.accept();
            r = new InputStreamReader(s.getInputStream());
            buf = new BufferedReader(r);
            checkFlag();
            connection = true;
            ConnectionAction.connection();


            while (true) {

                if (connection) {
                    r = new InputStreamReader(s.getInputStream());

                    str = buf.readLine();

                    if (str != null) {
                        if (str.equals("//disable")) {
                            connection = false;
                        } else {
                            Date d = new Date();
                            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
                            String text = str;
                            text = text + "\r\n";
                            Interface.textArea.append("Stranger: " + text);
                            StringBuilder sb = new StringBuilder();
                            sb.append("[");
                            sb.append(format1.format(d));
                            sb.append(" | Str]:  ");
                            sb.append(text);
                            TextFile.update(sb.toString());
                        }
                    }

                } else {
                    //============================================DISCONNECTING===========================================
                    Interface.cli.closing();
                    server.close();
                    DisconnectionAction.disconnection();
                    Interface.clientFlag = false;
                    TextAction.online = false;
                    Interface.status.setText("Connect to somebody");
                    flag = false;
                    while (!flag) {

                        try {
                            server = new ServerSocket(port);
                            Interface.connectionStatus.setText("You are available");
                            Interface.connectionStatus1.setText("on port " + port);
                            flag = true;
                        } catch (BindException e) {
                            port = port + 1;
                        }
                    }
                    s = server.accept();
                    r = new InputStreamReader(s.getInputStream());
                    buf = new BufferedReader(r);
                    checkFlag();
                    connection = true;
                    ConnectionAction.connection();

                }
            }

        } catch (Exception e) {
            System.out.println("initt error: " + e);
        }
    }

}
