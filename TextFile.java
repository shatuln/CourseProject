import java.io.*;

public class TextFile {
    private static String fileName = "text.txt";
    public static File file = new File(fileName);

    public static void update(String newText) {
        exists();
        StringBuilder sb = new StringBuilder();
        String oldFile = read();
        sb.append(oldFile);
        sb.append(newText);
        write(sb.toString());
    }

    private static void write(String text) {

        try {
            exists();

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read() {
        StringBuilder sb = new StringBuilder();

        exists();

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\r\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static void exists() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}

