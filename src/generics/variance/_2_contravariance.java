package generics.variance;

import java.util.ArrayList;
import java.util.List;

public class _2_contravariance {
  /**
   * In Java method parameter display contravariance
   * i.e. if sub class' overridden method cannot substitute a more specific type parameter
   * This is demonstrated in the examples
   */
}

class Zoo {
  void process(ArrayList<? extends Integer> list) {}

  List<? extends Number> guide() { return null;}
}

class Boo extends Zoo {

  /**
   * process(ArrayList<? extends Integer>)' in sub-class clashes with
   * 'process(ArrayList<? extends Number>)' in super-class
   * both methods have same erasure, yet neither overrides the other
   * @param list
   */
  //void process(ArrayList<? extends Integer> list) {}  //cannot compile

  void process(List<? extends Number> list) {} //compiles

  ArrayList<? extends Integer> guide() { return null;} //compiles since return type parameter is
                                                      // covariant
}
