package generics.bounded;

import java.util.Comparator;
import java.util.List;

public class _1_Uppper_Bound {
  void main() {
    Data<MyCustomer> data = new Data<>();
    MyCustomer mc = new MyCustomer(10.50);
    data.e = mc;
    data.useData();
    mc.run();
    System.out.println(mc.intValue()+","+ mc.floatValue());
    System.out.println(mc.compareTo(11.80));
  }

}

/**
 * DataHolder is upper bounded by Number class
 * @param <E>
 */
class DataHolder<E extends Number> {
  E e;
  void setData(E e) { this.e = e;}
  E getData() {
    return e;
  }
  void useData() {
    System.out.println(e.intValue());
  }

}
/**
 * Multiple upper bounds
 */
class Data<E extends Number & Comparable<? extends Number> & Runnable> {
  E e;
  void useData() {
    System.out.println("Processing the value of: "+ e);
  }
}

/**
 * Class which satisfies the above Type parameter
 */
class MyCustomer extends Number implements Comparable<Double>,Runnable {

  private Double e;

  MyCustomer(Double e) {
    this.e =  e;
  }

  @Override
  public int compareTo(Double o) {
    return Double.compare(e,o);
  }

  @Override
  public int intValue() {
    return e.intValue();
  }

  @Override
  public long longValue() {
    return e.longValue();
  }

  @Override
  public float floatValue() {
    return e.floatValue();
  }

  @Override
  public double doubleValue() {
    return e.doubleValue();
  }

  @Override
  public void run() {
    System.out.println("Running...");
  }

  @Override
  public String toString() {
    return "MyCustomer{" +
        "e=" + e +
        '}';
  }
}



/**
 * There is no Lower bounded generic type parameter
 */
//class Invalid<E super Number> {} //invalid case
