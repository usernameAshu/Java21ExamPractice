package streams;

import java.util.Arrays;
import java.util.List;

public class Basics {

    public static void main(String[] args) {

        //create a list of Cities
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata");

        //create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Jack", 20),
                new Person("Jill", 35)
        );

        people.stream()
                .filter(person -> person.getAge() > 25)
                .forEach(p -> p.name = "Test");

        people.forEach(System.out::println);


    }
}

//create Person class
class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

