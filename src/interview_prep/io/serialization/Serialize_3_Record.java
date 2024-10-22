package interview_prep.io.serialization;

import interview_prep.io.records.Location;
import interview_prep.io.records.Statue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* Serializing the records properly */
public class Serialize_3_Record {
    public static void main(String[] args) {
        var statue = new Statue("Liberty", 150, new Location("NY", "US"));

        try(var out = new ObjectOutputStream(new FileOutputStream("serial.data"));) {
            out.writeObject(statue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
