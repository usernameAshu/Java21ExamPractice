package enthuware_guide.io_nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _4 {
    public static void main(String[] args) {
        String src = "C:/temp/test-file1.txt";
        String dest = "C:/temp/test-file3.txt";

        try {
            Path destPath = Path.of(dest);
            Files.deleteIfExists(destPath);
            Files.createFile(destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] buffer = new char[5];
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
                OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(dest));
                ) {
            int charRead = -1;
            while( (charRead = isr.read(buffer)) != -1) {
                for(char c: buffer) System.out.print(c);
                osr.write(buffer, 0, charRead);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
