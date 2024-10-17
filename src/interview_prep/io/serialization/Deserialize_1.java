package interview_prep.io.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* Turn on all the checks in Statue object and deserialize */
public class Deserialize_1 {
    public static void main(String[] args) {

        //reading the sanitized data
        try(var in = new ObjectInputStream(new FileInputStream("serial.data"));) {
            var statue = (Statue) in.readObject();
            System.out.println(statue);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        /* reading the malicious data
          instead of Statue object being malicious, code
          will be able to deserialize back to Statue class with negative height
         */
        try(var in = new ObjectInputStream(new FileInputStream("virus.data"));) {
            var virus = in.readObject();
            System.out.println(virus);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
