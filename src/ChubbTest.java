import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ChubbTest {

  void main() {

    HashMap<String, String> map = new HashMap<>();
    map.put("Emp1", "1000");
    map.put("Emp2", "5000");
    map.put("Emp3", "1000");
    map.put("Emp4", "3000");
    map.put("Emp5", "5000");

    //group by salary
    //1000: Emp1 Emp2
    //{5000=[Emp2, Emp5], 1000=[Emp1, Emp3], 3000=[Emp4]}

//    Map<String, List<String>> mapList=

    Map<String, List<String>> groupedBySalary =
    map.entrySet()
        .stream()
        .collect(
            Collectors.groupingBy(
                entry -> entry.getValue(),
                Collectors.mapping(entry -> entry.getKey(), Collectors.toList())
        ));

    Map<String, List<String>> collect = map.entrySet().stream()
        .collect(Collectors.groupingBy(Entry::getValue,
            Collectors.mapping(Entry::getKey, Collectors.toList())
        ));

    System.out.println(groupedBySalary);
    System.out.println(collect);

    Calc add = (a, b) -> a + b;
    Calc minus = (a, b) -> a - b;

    System.out.println(add.sum(10, 20));
    System.out.println(minus.sum(20, 10));
  }
//Spring - Cyclic

  //dev

  /*
  Maximize Profit. Cost Price of 1 Stock from Day-1 to Day-7 is as follows,
  Input: 6, 4, 2, 4, 3, 20, 1
                i        j
  Output: Day-3 & Day-6
   */

  //2 pointer app
  //    1st pointer(i), 2nd pointer (j)
  // buy , sell
  // pp = j - i
  // if(j < i ) : i++, j++
  // if(i < j) : j++, p = j -i; pp =p;
  //
}

interface Calc {

  int sum(int a, int b);
}
