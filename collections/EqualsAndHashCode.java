package collections;

import java.util.*;

class Employee {
    int id;
    String name;

    // Override the equals method to compare Employee objects based on their id and name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && name.equals(employee.name);
    }

    // Override the hashCode method to return a hash code based on the id and name fields
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class EqualsAndHashCode {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "John");
        Employee employee2 = new Employee(1, "John");

        // Shallow compare: compares memory addresses, always false for different objects
        System.out.println("Shallow Compare: " + (employee1 == employee2));

        // Deep compare: compares the actual content based on the equals method
        System.out.println("Deep Compare: " + employee1.equals(employee2)); //true if we override the hash method or otherwise false

        // Print hash codes of the Employee objects
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());

        // Create new String objects, which are not interned
        String s1 = new String("Sunil");
        String s2 = new String("Sunil");

        // Print hash codes of the String objects
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        // Deep compare of the String objects using the inbuilt equals method
        System.out.println(s1.equals(s2));

        // Using a HashMap to demonstrate the importance of hashCode implementation
        Map<Employee, String> map = new HashMap<>();
        map.put(employee1, "Manager");

        // Without proper hashCode implementation, this would return null
        System.out.println(map.get(employee2));
    }
}
