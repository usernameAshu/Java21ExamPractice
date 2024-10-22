package interview_prep.io.serialization;

import interview_prep.io.records.Statue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* Turn on all the checks in Statue records and deserialize */
public class Deserialize_2_Records {
    public static void main(String[] args) {

        //reading the sanitized data
        try(var in = new ObjectInputStream(new FileInputStream("serial.data"));) {
            var statue = (Statue) in.readObject();
            System.out.println(statue);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        /* In case of records Serialization works properly
        as the object is not created from backdoor, but created by using the canonical constructor
        So, any malicious code cannot turn itself back into object
         */
        try(var in = new ObjectInputStream(new FileInputStream("virus.data"));) {
            var virus = in.readObject();
            System.out.println(virus);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
