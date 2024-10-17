package interview_prep.io.serialization;

import java.io.*;

/*
Demonstrate the effect of Serialization on inheritance
If Parent class is serializable, then child classes are automatically covered
If only Child class are serializable, then while deserailization , parent variables are installed to their default values
 */
public class Serialize_5 {
    public static void main(String[] args) {
        var mobile = new Electronics("Mobile", "Iphone", 400);

        /* serialize the object into stream and store as binary in memory */
        try(var out = new ObjectOutputStream(new FileOutputStream("data.ser"));) {
            out.writeObject(mobile);

        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* deserialize */
        try (var in = new ObjectInputStream(new FileInputStream("data.ser"));) {
            var prod = (Product)in.readObject();
            System.out.println(prod);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
