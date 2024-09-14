package interview_prep;

public class Practice3 {
    public static void main(String[] args) {
        Apple apple = new Apple(10, "red");
        Foo foo = new Foo(10, "foo", apple);
        Foo copy = foo.clone();
        copy.apple.a = 20;
        copy.apple.b = "green";
        System.out.println(foo.apple +"\n"+ copy.apple);
    }
}

class Apple {
    int a;
    String b;

    public Apple(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Apple[" +
                "a=" + a + ", " +
                "b=" + b + ']';
    }
}


class Foo  implements Cloneable{
    int a;
    String b;
    Apple apple;

    public Foo(int a, String b, Apple apple) {
        this.a = a;
        this.b = b;
        this.apple = apple;
    }

    @Override
    public Foo clone() {
        try {
            Foo copy = (Foo) super.clone();
            copy.apple = new Apple(this.apple.a, this.apple.b);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

