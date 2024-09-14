package interview_prep.interviewQstns;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting {

    /**
     * LinkedList : 1 -> 2 -> 4 -> 3 -> 5
     * @param args
     */
    public static void main(String[] args) {

        new Sorting().test();
    }

    void test() {
        //emp obj -> list of emps,
        //generate a map -> key: no of employees name size , val: emp name

        List<Employee> emps = List.of(new Employee("Ashutosh"), new Employee("Manoj"), new Employee("Susan"));
        Map<Integer, String> map = new HashMap<>();
        //simple
        emps.stream()
                .forEach( emp -> {
                    map.put(emp.name.length(), emp.name);
                });

        map.forEach((k,v) -> System.out.println(k+":"+v));

        Map<Integer, String> collect = emps.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.name.length(),
                        Collectors.reducing("", emp -> emp.name, (s1, s2) -> s1 + " " + s2)
                ));

        //Generate a map -> key: no of employees name size , val: emp name
        Map<Integer, String> collect2 = emps.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.name.length(),
                        Collectors.reducing(
                                "",
                                emp -> emp.name,
                                (s1, s2) -> s1 + " " + s2
                        )
                ));

        Map<Integer, String> collect1 = emps.stream()
                .map(employee -> employee.name)
                .collect(Collectors.groupingBy(String::length,
                        Collectors.reducing("", (s1, s2) -> s1 +" "+ s2)));

        System.out.println(collect1);

    }

}

class Employee {
    String name;
    Employee(String name){
        this.name = name;
    }
}

