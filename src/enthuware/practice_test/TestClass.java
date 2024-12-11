package enthuware.practice_test;

class Book {
    protected final int pages = 100;

    final void mA() {
        System.out.println("In B.mA " + pages);
    }
}

class Encyclopedia extends Book {
    private int pages = 200;

    void mB() {
        System.out.println("In E.mB " + pages);
    }

    /* invalid, since overriden method is final in parent class */
    /*void mA() {
        System.out.println("In E.mA " + pages);
    }*/
}

public class TestClass {
    public static void main(String[] args) {
        Book o1 = new Encyclopedia();
        Book o2 = new Book();
        o1.mA();
        /*o1.mB();*/ /*Invalid , because mB() candidate is not present in Book */
        o2.mA();
    }
}