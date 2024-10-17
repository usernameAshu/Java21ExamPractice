package interview_prep.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadChars_2 {

    public static void main(String[] args) throws IOException {
        try (Reader in = new FileReader("Message.txt", StandardCharsets.UTF_8);
             Writer out = new FileWriter("Output2.txt", StandardCharsets.UTF_8)) {

            char[] buffer = new char[1024];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
    }
}
