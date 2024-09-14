package interview_prep;

public class Practice2 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.m1();
    }
}


class Parent {
    public void m1() {
        System.out.println("Parent.m1");
    }
}

class Child extends Parent {
    public void m1() {
        System.out.println("Child.m1");
    }
}

