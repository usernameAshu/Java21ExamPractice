package enthuware_guide.io_nio;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class _2 {

    public static void main(String[] args) {
        String src = "C:/temp/test-file.txt";
        String dest = "C:/temp/test-file2.txt";

        try {
            Path destPath = Path.of(dest);
            Files.deleteIfExists(destPath);
            Files.createFile(destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (   FileInputStream fis = new FileInputStream(src);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                FileOutputStream fos = new FileOutputStream(dest);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                ) {

            char[] buffer = new char[1024];
            int charRead = -1;
            while((charRead = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, charRead);
            }

        } catch(IOException e) {}

    }
}
