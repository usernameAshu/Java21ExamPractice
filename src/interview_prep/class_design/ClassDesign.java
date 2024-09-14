package interview_prep.class_design;

public class ClassDesign {
    public static void main(String[] args) {
        //create an object of the outer class
        Foo foo = new Foo();

        //create an object of the inner class
        Bar bar = new Bar();
        Bar.Baz baz = bar.new Baz();

        //create an object of the static nested class
        Qux.Quux quux = new Qux.Quux();

        //cannot create an object of local inner class
        Corge corge = new Corge();
        corge.display();
    }
}

//outer class
class Foo {
    private int a = 10;
}

//inner class
class Bar {
    private int b = 20;
    class Baz {
       void display() {
           System.out.println(b);
       }
    }
}

//static nested class
class Qux {
    private static int c = 30;
    static class Quux {
        void display() {
            System.out.println(c);
        }
    }
}

//Local Inner class
class Corge {
    private int d = 40;
    void display() {
        class Grault {
            void display() {
                System.out.println(d);
            }
        }
        Grault grault = new Grault();
        grault.display();
    }
}
