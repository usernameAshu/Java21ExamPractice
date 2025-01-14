package generics.unbounded;

public class TypeErasure {
  void main() {

  }
}

class DataHolder<T> {
  T t;
  DataHolder() {
  }
  DataHolder(T t) {
    this.t = t;
  }
  T getData() {
    return t;
  }
}
//impact on method overloading
/*
processData(DataHolder<String>)' clashes with 'processData(DataHolder<Integer>)';
both methods have same erasure
Due to Type erasure, compiler won't allow 2 same methods to have different type-parameter,
since to compiler eyes, after removing the Type both method have same signature.
 */
class TestClass {
//  public void processData(DataHolder<String> d){ String s = d.getData();}
//  public void processData(DataHolder<Integer> d) { Integer i = d.getData();}
//  public void processData(DataHolder<Integer> d) { Integer i = d.getData();}
}


//impact on method overriding
/*
SubClass cannot override the method with a different type parameter,
compiler will throw this error that: both method clash with each other. Both have same type erasure

Compiler notices that processData method is invoked with DataHolder containing a String,
but while runtime, it's cast to integer. So, when di.getData() will return a String, it will throw error.
So, compiler will not allow the code to compile.
 */
 class Base {
  public void processData(DataHolder<String> ds) {
    String s = ds.getData();
  }
 }
 class SubClass extends Base {

   /*public void processData(DataHolder<Integer> di) {
    Integer i =  di.getData(); }*/

   public void processData(DataHolder<String> ds) {
    String i =  ds.getData()+ " modification"; }
 }