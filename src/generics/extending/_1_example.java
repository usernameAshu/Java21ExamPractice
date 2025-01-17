package generics.extending;

public class _1_example {
 void main() {

 }
}

interface Processor<T> {
  void process(T t);
}

interface AdvancedProcessor<U> extends Processor<U> {
  void processFast(U t);
}

class StringProcessor implements Processor<String> {
  public void process(String s) {}
}