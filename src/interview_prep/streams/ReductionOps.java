package interview_prep.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ReductionOps {

    public static void main(String[] args) {
        // Generate a List of alphabets from 'A' to 'Z'
        List<String> alphabets = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> String.valueOf((char) c))
                .toList();

        System.out.println(alphabets);

        //reduction methods:
        //simple reductions

        Optional<String> r1 = alphabets.stream()
                .reduce((s1, s2) -> s1 + "," + s2);
        System.out.println(r1.isPresent() ? r1.get() : "No data");

        //reduction with initial value
        String r2 = alphabets.stream()
                .reduce("Init ", (s1, s2) -> s1 + ", " + s2);
        System.out.println(r2);

        //reduction with initial value, accumulator and combiner
        String r3 = alphabets.stream()
                .sorted()
                .reduce("Init", (u, s) -> u + "," + s, (s1, s2) -> s1 + s2);
        System.out.println(r3);

        //same thing with Product list
        List<Product> prods = Utils.generateProductData();
        String prodNames = prods.stream()
                //.sorted((p1,p2) -> p2.getName().compareTo(p1.getName()))
                .reduce("", (s, p) -> p.getName() + " " + s, (s1, s2) -> s1 + s2);
        System.out.println(prodNames);



    }
}
