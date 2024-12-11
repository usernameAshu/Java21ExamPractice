package interview_prep.CollectionsFramework;

import java.util.HashSet;
import java.util.Set;

public class SetFuncs {
    public static void main(String[] args) {
        /* Default capacity is 16 elements
           We can specify load factor , which touched , it will auto expand
           Set can be populated based on list, duplicates will be discarded
         */

        Set<Product> set = new HashSet<>();
        /*
        hashset is backed by a hash table (actually a HashMap instance). order is not guaranteed
         can persist one null value
         */
        Product tea1 = new Product("Tea", 10);
        Product tea2 = new Product("Tea", 12);
        System.out.println(tea1.hashCode()+" , "+ tea2.hashCode());
        System.out.println(tea1.equals(tea2));
        set.add(tea1);
        set.add(tea2);

        System.out.println(set);
    }
}
