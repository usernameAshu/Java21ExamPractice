package generics.variance;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrating covariance in generics type
 */
public class _1 {
  void main() {
    Sample s = new Sample();
    List<Integer> intlist = new ArrayList<>();
    ArrayList<Integer> intArList = new ArrayList<>();
    s.process(intlist);
    s.process(intArList);
  }
}

//covariance in generic type
class Bar {
  List<?> process(List<? extends Number> list) {
    return list;
  }
}
class Foo extends Bar {
  @Override
  ArrayList<?> process(List<? extends Number> list) {
    return new ArrayList<>();
  }
}

//covariance in type parameter (bounded wildcard)
class Base {
  List<? extends Number> getList() {
    return new ArrayList<Integer>();
  }

  List<?> something() {
    return new ArrayList<String>();
  }
}
class Sub extends Base {
  @Override
  List<? extends Integer> getList() {
    return new ArrayList<Integer>();
  }

  @Override
  ArrayList<Integer> something() {
    return new ArrayList<>();
  }
}

/**
 * covariance in parameterized type.
 * Both overloaded methods must not have the same type erasure
 */
class Sample {
  List<? extends Number> process(List<? extends Number> list) {return new ArrayList<>();}

  ArrayList<?> process(ArrayList<Integer> list) { return new ArrayList<>();}
}