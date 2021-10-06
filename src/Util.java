import java.awt.*;
import java.io.*;

public class Util {
    public static void copyFileUsingStream(File source, File dest, Label status) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        long complete=0;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                complete+=1024;
                status.setText(complete+"");
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
