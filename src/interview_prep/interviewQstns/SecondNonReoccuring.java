package interview_prep.interviewQstns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecondNonReoccuring {

    public static void main(String[] args) {
        char result = new SecondNonReoccuring().findNonRecoccuring("geeksforgeeks", 2);

        System.out.println(result);
    }

    public char findNonRecoccuring(String str, int k) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        //geeksforgeeks

        int i = 0;
        while (i < str.length()) {
            char s = str.charAt(i);
            if (map.containsKey(s)) {
                set.remove(s);
            } else {
                set.add(s);
                map.put(s, 1);
            }
            System.out.println();
            set.stream()
                    .forEach(System.out::print);
            i++;
        }

        System.out.println("\n-----final-----------");
        set.stream()
                .forEach(System.out::print);

        if (set.size() > k - 1)
            return set.iterator().next().charValue();
        else
            return 32;
    }
}
