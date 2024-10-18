package interview_prep.generics_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare_Interfaces {
    public static void main(String[] args) {
        /* comparing using comparator interface
        If 1st object < 2nd object -> -ve
        If 1st object = 2nd object -> 0
        if 1st object > 2nd object -> +ve
         */
        Comparator<Animal> comparator = (a1, a2) -> a1.getName().compareTo(a2.getName());

        /* using both Comparable and Comparator in Sorting */
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("1934", "Ashutosh", 29, "moha@asas"));
        persons.add(new Person("1235", "Aajay", 29, "moha@asas"));
        persons.add(new Person("1237", "Aajay", 29, "moha@asas"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tiger", "Savana"));
        animals.add(new Animal("Lion", "Savana"));

        Collections.sort(persons);
        System.out.println(persons);

    }
}

/*
comparing objects using Comparable interface
 */
class Person implements Comparable<Person> {

    private String adhaarUID;
    private String name;
    private int age;
    private String email;


    public Person(String adhaarUID, String name, int age, String email) {
        this.adhaarUID = adhaarUID;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public int compareTo(Person o) {
        return this.adhaarUID.compareTo(o.adhaarUID);
    }
}

class Animal {
    private String name;
    private String habitat;

    public Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }
}