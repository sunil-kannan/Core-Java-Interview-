package collections;

import java.util.*;

class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MutableHashSet {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("John");
        set.add(p1);
        System.out.println(set.contains(p1));

        p1.setName("Doe");
        System.out.println(set.contains(p1));
        set.remove(p1);
        System.out.println(set);
    }
}
