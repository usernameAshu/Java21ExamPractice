package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Wildcards {

  void main() {

    //wildcards
    List<Number> nums = new ArrayList<>();
    List<? extends Number> extNum = new ArrayList<>();
    List<? super Number> supNum = new ArrayList<>();
    List<?> opn = new ArrayList<>();

    Pair<String, Integer> p = new Pair<>();
    p.setValues("Ashutosh", 10000);
//    p.display();
  }

}

//class with multiple type parameter
class Pair<E1, E2> {
  E1 el_1;
  E2 el_2;

  void setValues(E1 el1, E2 el2) {
    this.el_1 = el1;
    this.el_2 = el2;
  }

  void display() {
    System.out.println(el_1+" : "+ el_2);
  }
}