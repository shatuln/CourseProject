import java.io.*;

public class TextFile {
    private static String fileName = "text.txt";
    static File file = new File(fileName);

    public static void update(String newText) {
        exists();
        StringBuilder sb = new StringBuilder();
        String oldFile = read();
        sb.append(oldFile);
        sb.append(newText);
        write(sb.toString());
    }

    public static void write(String text) {

        try {
            //проверяем, что если файл не существует то создаем его
            exists();

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read() {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists();

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\r\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
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

