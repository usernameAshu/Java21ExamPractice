import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestNet {

  public static int globInt = 0;

  void main() {
    //list strings names
    //convert to Map<Index,

    List<String> list = List.of("Ashutosh", "Mohanty", "Sky", "Earth");

    //convert to map
    //{ [0:Ashutosh], [1:Moahnty] , }

    Map<Integer, String> result =
        list.stream()
            .collect(Collectors.toMap(str -> getIndex(), str -> str ));

    result.forEach((k,v) -> System.out.println(k+" : "+ v));
  }

  private static Integer getIndex() {
    return globInt++;
  }

}
