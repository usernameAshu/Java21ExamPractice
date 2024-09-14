package interview_prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        new Sorting().test();
    }

    void test() {
        List<String> names = new ArrayList<>(List.of("John", "Adam", "Donna", "Mary"));

        // Sort the list of names in ascending order
        Comparator<String> ascendingOrder = (s1, s2) -> s1.compareTo(s2);

        Comparable<String> comparable = (String s) -> s.length();

        names.sort(ascendingOrder);

        System.out.println(names);

    }

}
