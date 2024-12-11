package enthuware.practice_test;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();
        List<Integer> str3 = new ArrayList<>();
        Bar bar = new Bar();
        bar.processList(strs);
        bar.processList(str2);
        bar.processList(str3);
    }
}


class Foo {
    <T> List<T> processList(List<T> list) {
        return null;
    }
}

class Bar extends Foo {

    @Override
    <T> List<T> processList(List<T> list) {
        System.out.println("Bar.processList<T>");
        return null;
    }

    /* invalid Override since compiler's Type-erasure removes the generics resulting in erroneous params */
    /*@Override
    <T> List<T> processList(List<String> list) {
        return null;
    }*/

    /* overloaded method */
    List<String> processList(ArrayList<String> list) {
        System.out.println("Bar.processList<String>");
        return null;
    }

}

class Zar {
    /* 'm(Set<T>)' clashes with 'm(Set<String>)' & 'm(Set<Integer> set)';
    all methods have same erasure
     compiler removes the types resulting in 3 methods having same signature
     m(Set set)
     */

    /*
    public <T> void m(Set<T> set) {

    }

    public void m(Set<Integer> set) {

    }

    public void m(Set<String> set) {

    }
    */
}