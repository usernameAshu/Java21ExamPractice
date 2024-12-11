package enthuware_guide.io_nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Read line by line
 */
public class _3 {
    public static void main(String[] args) {
        String src = "C:/temp/test-file.txt";
        String dest = "C:/temp/test-file3.txt";

        try {
            Path destPath = Path.of(dest);
            Files.deleteIfExists(destPath);
            Files.createFile(destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //reading
        try (
                InputStream is = new FileInputStream(src);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = new FileOutputStream(dest);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //writing
                bw.write(line);
                bw.newLine();

            }
        } catch (IOException e) {
        }
    }
}
