package generics.bounded;

import java.util.ArrayList;
import java.util.List;

public class _2_Upper_Bound {

  void main() {
    List<Integer> intlist = new ArrayList<>();
    intlist.add(1);
    intlist.add(2);
    List<Double> dlist = new ArrayList<>();
    dlist.add(1.5);

    consumeExN(intlist);
    consumeExN(dlist);

//    consumeEsN(intlist); list has to be atleast Number type
    List<Number> numList = new ArrayList<>();
    numList.add(2.5);
    numList.add(5);
    consumeEsN(numList);
  }

  static void consumeExN(List<? extends Number> list) {
//    list.add(1.0); doesn't allow to add objects since lower class is unknown
    list.forEach(v -> System.out.print(v+" "));
    System.out.println();
  }

  static void consumeEsN(List<? super Number> list) {
    //here adding values are allowed since list will be atleast of Number type
    list.add(1.0);
    list.add(1);
    list.forEach(v -> System.out.print(v+" "));
    System.out.println();
  }

}
