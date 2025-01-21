import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestNetCracker_L2 {

  public static void main(String[] args) {
    List<String> str = new ArrayList<>();
    str.add("0");
    str.add("31");
    str.add("8");
    str.add("3");
    str.add("81");
    str.add("29");

    System.out.println(generateLargestNumber(str));

  }

  static String generateLargestNumber(List<String> ar) {
    //sort array in descending order considering 1st el
    //{81, 8, 6, ....
    //check max 1st element of each number

    System.out.println(ar);
    Comparator<String> comp = (s1, s2) -> {
      String str1 = s1 + s2;
      String str2 = s2 + s1;
      return str2.compareTo(str1);
    };
    ar.sort(comp);

    //System.out.println(ar);
    return String.join("", ar);
  }
}
