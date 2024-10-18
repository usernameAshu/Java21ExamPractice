package interview_prep.generics_interfaces;

public class SuperSubInterface {
    public static void main(String[] args) {
        B b = new B();
        b.n();
    }
}

interface b1 {
    public void m();
    public void n();
}
interface b2 extends b1 {
    public void m();
    public default void n() {}
}
class B implements b2 {
    @Override
    public void m() {}
}