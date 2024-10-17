package interview_prep.io;

import java.io.*;

public class ReadBinary_1 {
    public static void main(String[] args)  {

        try( InputStream fis = new FileInputStream("Message.txt");
             OutputStream fos = new FileOutputStream("Output.txt");) {

            byte[] buffer = new byte[1024];
            int length = 0;
            while( (length = fis.read(buffer)) != -1 ) {
                fos.write(buffer, 0, length);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
