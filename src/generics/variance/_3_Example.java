package generics.variance;

import java.util.ArrayList;
import java.util.List;

public class _3_Example {
  void main() {
    //List<Fruit> fruits = new ArrayList<Apple>(); //invariant
    //List<Apple> apples = new ArrayList<Fruit>(); //invariant

    List<? extends Number> nums = new ArrayList<Integer>(); //covariant for bounded wildcard

  }

}

class Fruit {}

class Apple extends Fruit {}

class Orange extends Fruit {}

//covariance (We are selective what we give/output)
class FruitSequence {
  Fruit next() { return null; }
}

class AppleSequence extends FruitSequence {
  Apple next() {return new Apple();}
}

//contra-variance (We are liberal on what we accept/input)
class OrangeJuicer {
  void juice(Orange fruit) {}
}

class FruitJuicer extends OrangeJuicer {
  void juice(Fruit fruit) {}
}