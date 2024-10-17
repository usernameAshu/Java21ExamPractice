package interview_prep.io;

import java.io.*;

public class ConnectingStreams_3 {
    public static void main(String[] args) {
        //for convenient purpose, we can read the files as stream, convert to character and read as lines using
        // buffered-readers
        //same for writer as well

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Message.txt")));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Output3.txt")));) {

            String br;
            while( (br = in.readLine()) != null) {
                out.println(br);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
