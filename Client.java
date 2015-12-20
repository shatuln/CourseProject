import java.io.*;
import java.net.*;

public class Client extends Thread
{
    String ipf, pf;
    Socket s;
    boolean flag;

    Client(String ip, String port) {
        this.ipf = ip;
        this.pf = port;
        Interface.clientFlag = true;
    }

    public void closing() {
        try {
            s.close();
            flag = false;
        } catch (Exception e) {}

    }

    public void getMessage(String message) {
        try {

            if (!message.equals("//disable")) {
                PrintWriter w = new PrintWriter(s.getOutputStream(), true);
                w.println(message);
            } else
            {
                PrintWriter w = new PrintWriter(s.getOutputStream(), true);
                w.println(message);
                closing();
            }


        } catch (Exception e) {}
    }

    public void run()
    {
        try
        {
            try {
                s = new Socket(ipf, Integer.parseInt(pf));
                System.out.println(s);
                TextAction.online = true;
                flag = true;
            } catch (ConnectException e) {
                DisconnectionAction.disconnection();
                Interface.textArea.append("Unable to connect" + "\n");
            }

            while (flag) {
                sleep(100);
            }
            Interface.status.setText("Connect to somebody");

        }
        catch(Exception e)
        {System.out.println("init error: "+e);} // вывод исключений
    }
}