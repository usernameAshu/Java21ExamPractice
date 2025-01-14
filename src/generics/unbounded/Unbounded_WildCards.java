package generics.unbounded;

public class Unbounded_WildCards {

  void main() {
    DataHolderx<Integer> dh = new DataHolderx<>(10);
    Utility.log(dh);

    DataHolderx<String> dh2 = new DataHolderx<>("Info Logs");
    Utility.log(dh2);
    dh2.setData("Ashu");
    Utility.log(dh2);
    System.out.println(dh2.getClass());
  }

}

class Utility {
  public static void log(DataHolderx<?> holder) {
    System.out.println("Logging: "+holder.getData());
  }
}

class DataHolderx<E> {
  E e;
  DataHolderx(E e) {
    this.e = e;
  }
  E getData() {
    return e;
  }
  void setData(E e) {
    this.e = e;
  }
}