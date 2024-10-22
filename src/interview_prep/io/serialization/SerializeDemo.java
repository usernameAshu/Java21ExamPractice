package interview_prep.io.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializeDemo {

    public static void main(String[] args) {
        SerializeDemo demo = new SerializeDemo();
        demo.test();
    }

    public void test() {
        Bar bar = new Bar(10, 20);
        System.out.println("original: " + bar);

        //use nio apis to write object to file
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of("bar.ser")))) {
            //write object to file
            oos.writeObject(bar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //read the file
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of("bar.ser")))) {
            //read object from file
            Bar copy = (Bar) ois.readObject();
            System.out.println("copy: " + copy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Foo {
    int a;

    public Foo() {
        //Default constructor must be present,
        //else app won't be able to deserialize Foo class
    }

    public Foo(int a) {
        this.a = a;
    }
}

class Bar extends Foo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    int b;

    public Bar(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public String toString() {
        return "Bar[" +
                "a=" + a + ", " +
                "b=" + b + ']';
    }
}

