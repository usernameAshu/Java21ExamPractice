package enthuware_guide.io_nio;

import java.io.*;

public class _1 {
    public static void main(String[] args)  {
        String src  = "C:\\temp\\test1.jpg";
        String dest = "temp\\test1.jpg";

        //read image
        System.out.println("Reading.....");
        try (var fis = new FileInputStream(src);) {

            //write
            System.out.println("Writing...");
            try(var fos = new FileOutputStream(dest)) {
                byte[] chunk = new byte[1024];
                int bytesRead = -1;
                while((bytesRead = fis.read(chunk)) != -1) {
                    for (byte b : chunk)
                        System.out.print(b + " ");
                    System.out.println();
                    fos.write(chunk, 0, bytesRead);
                }
            }
        } catch( IOException e) {}
    }
}
