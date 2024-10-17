package interview_prep.io.serialization;

import interview_prep.io.records.Location;
import interview_prep.io.records.Statue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* Serializing the records maliciously by turning off validation in record class*/
public class Serialize_4 {
    public static void main(String[] args) {
        var statue = new Statue("Liberty", -1, new Location("NY", "US"));

        try(var out = new ObjectOutputStream(new FileOutputStream("virus.data"));) {
            out.writeObject(statue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
