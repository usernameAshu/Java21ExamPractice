package interview_prep.immutable_class;

import java.util.ArrayList;
import java.util.List;

public class ImmutableClass {
    void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Foo foo = new Foo(1, "abc", list);
        System.out.println(foo.getA());
        System.out.println(foo.getB());
        System.out.println(foo.getList());
        list.add(4);
        System.out.println(foo.getList());
    }

    public static void main(String[] args) {
        new ImmutableClass().test();
    }


}

final class Foo {
    private final int a;
    private final String b;
    List<Integer> list;

    public Foo(int a, String b, List<Integer> list) {
        this.a = a;
        this.b = b;
        //Defensive copy
        this.list = new ArrayList<>(list);
    }

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public List<Integer> getList() {
        //return a defensive copy
        return new ArrayList<>(list);
    }


}
