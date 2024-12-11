package interview_prep.CollectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class ArraListFunctions {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        /* cannot add element to a position without filling previous positions */
        //list.add(2, "2");
        list.add(1, null);
        list.add("3");
        list.add("4");

        System.out.println(list);
        Product product = new Product();
        product.name = "Tea";
        product.price = 10;

        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add("One");
        objs.add(1.001);
        objs.add(product);
        System.out.println(objs);


    }
}