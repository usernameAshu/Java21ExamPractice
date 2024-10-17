package interview_prep.io.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize_1 {
    public static void main(String[] args) {
        //try to serialize the statue object
        var statue = new Statue("Liberty", 150, new Location("New York", "US"));

        try(var out = new ObjectOutputStream(new FileOutputStream("serial.data"));) {
            out.writeObject(statue);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}

