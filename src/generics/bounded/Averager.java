package generics.bounded;

import java.util.ArrayList;
import java.util.List;

public class Averager {

  void main() {
    List<Integer> ints = new ArrayList<>();
    ints.add(1);
    ints.add(2);
    double result = averageExN(ints);
    double result2 = averageExN2(ints);
    System.out.println(result);
    System.out.println(result2);
    //averageN(ints); -> since generic type is invariant, so it will be incompatible types (compile-error)
  }

   static <E extends Number> double averageExN(List<E> list) {
    double sum = 0.0;
    for(Number n: list) {
      sum += n.doubleValue();
    }
    return sum/list.size();
  }

  static double averageN(List<Number> list) {
    double sum = 0.0;
    for(Number n: list) {
      sum += n.doubleValue();
    }
    return sum/list.size();
  }

  /*
  Just examples of Generic Type and Wildcard usages in method definition
   */
  //same averageExN can be also written using wildcard in parameter, more concise:
  static double averageExN2(List<? extends Number> list) {
    double sum = 0.0;
    for(Number n: list) {
      sum += n.doubleValue();
    }
    return sum/list.size();
  }

  static <E extends Number> List<E> process(List<E> list) {
    return list;
  }

  static List<? extends CharSequence> processS(List<? extends CharSequence> chars) {
    return chars;
  }

}
