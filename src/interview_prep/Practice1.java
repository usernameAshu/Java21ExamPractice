package interview_prep;

public class Practice1 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
    }
}


interface A {
    void m1();

    default void m2() {
        System.out.println("A.m2");
    }
}

interface A1 extends A {
    void m1();

    @Override
    default void m2() {
        System.out.println("A1.m2");
    }
}


interface B {
    void m1();

    default void m2() {
        System.out.println("B.m2");
    }
}

class C implements A, B {
    @Override
    public void m1() {
        System.out.println("C.m1");
    }

    @Override
    public void m2() {
        A.super.m2();
    }
}
