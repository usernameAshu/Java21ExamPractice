package generics.unbounded;

public class Adv_Type_Erasure {

}


class MessageHolder<T> extends DataHolderz<T> {
    T t;
    MessageHolder() {}
    MessageHolder(T t) {super(t);}
}

class DataHolderz<T> {
  T t;
  DataHolderz() {
  }
  DataHolderz(T t) {
    this.t = t;
  }
  T getData() {
    return t;
  }
}
/*
In generics, the Type is covariant , but the generic parameter is invariant
 */
class Basez {
  public void processData(DataHolderz<String> ds) { String s = ds.getData();}
}

class SubClassz extends Basez {
  public void processData(MessageHolder<String> ms) {String s = ms.getData();} //allowed

  //public void processData(DataHolderz<Integer> di) { Integer i = di.getData();} //not allowed
}
