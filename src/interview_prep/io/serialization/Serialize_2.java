package interview_prep.io.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* We need to create a malicious statue object by turning off the height check */
public class Serialize_2 {
    public static void main(String[] args) {
        /* construct this malicious statue by turning off the height check */
        var malStatue = new Statue("Liberty", -1, new Location("NY", "US"));

        try(var out = new ObjectOutputStream(new FileOutputStream("virus.data"));) {
            out.writeObject(malStatue);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
