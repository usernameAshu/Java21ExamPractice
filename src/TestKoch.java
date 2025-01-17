import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestKoch {

  void main() {
    //int array
    //[1,2,3,4,5] => [3,4,5] [1,2]
    //rotate by +2
    //o/p: [4,5,1,2,3]
    //rot: 3
    //o.p: [3,4,5,1,2]
    //rot: 6 => 1

    int[] input = {1,2,3,4,5};
    int[] rotate = rotate(input, 6);
    System.out.println(Arrays.toString(rotate));

    /**
     * SQL:
     * Employee table (sal:int, desg:int)
     * Get emps, who has lowest desg. If multiple emp, we need to compare sal and return highest sal emp
     */

//    [[1000, 1], [20000, 2], [3000, 0], [4000, 0]]
    Employee e1 = new Employee(1000, 1);
    Employee e2 = new Employee(2000, 2);
    Employee e3 = new Employee(3000, 3);
    Employee e4 = new Employee(4000, 0);
    Employee e5 = new Employee(5000, 0);

    List<Employee> emps = new ArrayList<>();
    emps.add(e1);
    emps.add(e2);
    emps.add(e3);
    emps.add(e4);
    emps.add(e5);

    Map<Integer, List<Integer>> resultMap =
        emps.stream()
            .collect(Collectors.groupingBy(emp -> emp.desg,
                Collectors.mapping( emp-> emp.sal,
                Collectors.toList()) ));

    System.out.println(resultMap);

    resultMap.keySet().stream()
        .sorted().limit(1).forEach( key -> {
            List<Integer> sals = resultMap.get(key);
            sals.stream()
                .sorted((i1,i2) -> i1 - i2);
          System.out.println("Designation: "+ key+ " Salary:"+ sals.get(0));
        });

    Comparator<Employee> desgComp = (emp1, emp2) -> {
      if(emp1.desg - emp2.desg == 0) {
        return emp2.sal - emp1.sal;
      }
      return emp1.desg - emp2.desg;
    };

    System.out.println("------------");
    System.out.println(emps);
    emps.sort(desgComp);
    System.out.println(emps);

    System.out.println("Answer:" +emps.get(0));
  }

  class Employee {
    public int sal;
    public int desg;
    public Employee(int sal, int desg) {
      this.sal = sal;
      this.desg = desg;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "sal=" + sal +
          ", desg=" + desg +
          '}';
    }
  }
  /**
   *
   */
  static int[] rotate(int[] input, int rotation) {
    int L = input.length;
    /*edge cases*/
    if(rotation > L) rotation = rotation - L;

    int[] endArray = new int[L];
    int eI = 0;
    //end array
    for(int index = L- rotation; index< L; index++) {
      endArray[eI] = input[index];
      eI++;
    }

    //result array
    int iI=0;
    for(int index=eI; index<L; index++) {
      endArray[index] = input[iI];
      iI++;
    }
    return endArray;
  }

}
