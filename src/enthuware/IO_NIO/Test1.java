package enthuware.IO_NIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test1 {
    public static void main(String[] args) throws IOException {
        var s = "hello";
        byte b = 100;
        Path p = Path.of("temp/data.bin");
        Files.createFile(p);

        /* write */
        try (var fos = new FileOutputStream("temp/data.bin");
             var dos = new DataOutputStream(fos);) {
            dos.writeUTF(s);
            dos.writeByte(b);
        }

        /* read */
        try( var fis = new FileInputStream("temp/data.bin");
             var dis = new DataInputStream(fis);) {

            byte[] buffer = new byte[4];

            while(dis.read(buffer) != -1) {
                for(byte buff: buffer)
                    System.out.print(buff+" ");
            }

        } finally {
            Files.deleteIfExists(p);
        }

    }
}
