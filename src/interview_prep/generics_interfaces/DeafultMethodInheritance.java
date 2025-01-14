package interview_prep.generics_interfaces;

public class DeafultMethodInheritance {
    public static void main(String[] args) {
        Z z = new Z();
        z.a();
        z.b();
        z.c();
    }
}
/*
When two interfaces contain the same default method. The method implementaion
of subinterface takes priority
 */
abstract  class W {
    public void a() {
        System.out.println("W.a");
    };
    public abstract void b();
}

interface X1 {
    public default void a() {
        System.out.println("X1.a");
    }
    public default void b() {
        System.out.println("X1.b");
    }
    public default void c() {
        System.out.println("X1.c");
    }
}

interface  X2 extends X1 {
    @Override
    public default void c() {
        System.out.println("X2.c");
    }
}

class Z extends W implements X2 {

    @Override
    public void b() {
        System.out.println("Z.b");
    }

}

/*
Two implementing interfaces have same default method
Implemented class can point to which implementation it can take
 */
interface a1 { public default void b() {
    System.out.println("a1.b");
} }
interface a2 {public default void b() {
    System.out.println("a2.b");
}}

class Y implements a1, a2 {

    @Override
    public void b() {
        a1.super.b();
    }
}