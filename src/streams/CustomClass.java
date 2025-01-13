package streams;

import java.util.List;

/**
 * Demonstration of Custom generic classes
 * A custom generic interface can be implemented by multiple solid class,
 * which can have their own type.
 */
public class CustomClass {

  public static void main(String[] args) {
    Pikun p = new Raja();
    List<String> fetch = p.fetch("1");
    System.out.println(fetch);
    p = new Ashutosh();
    List<Integer> intList = p.fetch("1");
    System.out.println(intList);
  }

}

interface Pikun<T> {

  <T> List<T> fetch(String id);

}

class Raja implements Pikun<String> {

  @Override
  public List<String> fetch(String id) {
    return List.of("ashu", "pikun", "raja");
  }
}

class Ashutosh implements Pikun<Integer> {

  @Override
  public List<Integer> fetch(String id) {
    return List.of(1,2,3,4,5);
  }
}