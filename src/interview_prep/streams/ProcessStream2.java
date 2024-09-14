package interview_prep.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ProcessStream2 {

    public static void main(String[] args) {
        Stream.of("Z","Y","A","B","A","C","D","E","F")
                .distinct()
                .sorted()
                .skip(1)
                .map(String::toLowerCase)
                .reduce((a,b) -> a + " " + b)
                .ifPresent(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("Y", 3);
        map.put("Z", 4);
        map.put("A", 1);
        map.put("B", 8);
        map.put("C", 3);

        map.entrySet().stream()
                .forEach( set -> System.out.println(set.getKey() + " " + set.getValue()));

        System.out.println("----Sorted by Value----");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach( set -> System.out.println(set.getKey() + " " + set.getValue()));

    }
}
