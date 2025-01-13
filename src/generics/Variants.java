package generics;

import java.util.ArrayList;
import java.util.List;

public class Variants {

  void main() {

    Number[] nums = new Integer[10]; //compiles (covariant)
    nums[0] = 1;
    //nums[1] = 1.5;  //compile, but will throw ArrayStoreException
    //nums[2] = 2l;   //compile, but will throw ArrayStoreException

    //List<Number> nlist = new ArrayList<Integer>(); //will not compile, since it breaks type safety (invariant)

    List<Integer> ints = List.of(1, 2, 3, 4, 5, 6);
    List<Double> doubs = List.of(1.5, 2.5, 3.5, 4.5);

    printNumbers(ints);
    printNumbers(doubs);

  }

  public static void printNumbers(List<? extends Number> list) {
    String s =
        list.stream()
            .reduce(new StringBuilder(), (str, in) -> str.append(in).append(","),
                (in1, in2) -> in1.append(",").append(in2))
            .toString();

    System.out.println(s);
  }

}
