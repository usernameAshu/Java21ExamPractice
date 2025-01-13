package interview_prep;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test_Cand {
    public static void main(String[] args) {
        //list emp
        //name, dept(A,B,C), sal
        //group the depts , print the sum(sal) for each in desc order
        Emp e1 = new Emp("A", "Software", 1000);
        Emp e2 = new Emp("B", "Software", 9000);
        Emp e3 = new Emp("C", "Admin", 2000);
        Emp e4 = new Emp("D", "Admin", 1000);
        Emp e5 = new Emp("E", "Logistics", 4000);
        Emp e6 = new Emp("F", "Logistics", 1000);
/*
Software 10000
Logistics 5000
Admin 3000
 */

        List<Emp> emps = List.of(e1,e2,e3,e4,e5,e6);
        Map<String, Integer> result =
                emps.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.getDept(),
                                Collectors.reducing(0, e -> e.getSal(), (s1,s2)-> s1+s2)
                        ));

        result.forEach((k,v) -> System.out.println(k+":"+v));

        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey().reversed())
                .collect(Collectors.toUnmodifiableList())

//        result.entrySet()
//                .

        /*
        23 floors building
        3 lifts
        First lift to serve for a request
        (up/down)-> {group lift direction} -> {nearest direction lift should come}
         */






    }
}

class Emp {

    String name;
    String dept;
    int sal;

    public Emp(String name, String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
}
