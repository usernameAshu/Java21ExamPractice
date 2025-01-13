package interview_prep.stream_adv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduction {

    void main() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = nums.stream().reduce(0, (acc, curr) -> acc + curr);
        System.out.println(sum);

        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        //calulate the total length of strings in the list
        int sumOfStrs = strings.stream().parallel().reduce(0, (length, str) -> length + str.length(), (a, b) -> Integer.sum(a, b));

        System.out.println(sumOfStrs);

        //collect all elements of strings into a new list using reduce
        // Reduce operation
        // Reduce operation
        List<String> collected = strings.stream()
                                        .reduce(
                                                new ArrayList<>(),                // identity: initial empty list
                                                (list, element) -> {              // accumulator: add each element to the list
                                                    list.add(element);
                                                    return list;
                                                },
                                                (list1, list2) -> {               // combiner: merge two lists
                                                    list1.addAll(list2);
                                                    return list1;
                                                }
                                        );

        System.out.println("Collected List: " + collected);

        //From list of integers nums, compute the product of even numbers
        int prodEven =
        nums.stream()
            .reduce(1,
                    (acc, num) -> num % 2 == 0 ? num * acc : acc,
                    (num1, num2) -> num1 * num2);

        System.out.printf("Product = %d", prodEven);

    }
}
