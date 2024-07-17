## Java Collections and Data Structures

### Comparable and Comparator

#### Comparable

The `Comparable` interface is used to define the natural ordering of objects. A class that implements `Comparable` must override the `compareTo` method, which compares the current object with the specified object.

- **Method to Implement**: `compareTo(T o)`
- **Usage**: When you want objects of a class to be sorted by their natural ordering.

```java
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // Sorts by age
    }
}
```

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students); // Sorts by age
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }
    }
}

```

### Comparator
The `Comparator` interface is used to define a custom ordering of objects. A class that implements `Comparator` must override the `compare` method, which compares two specified objects.
- **Method to Implement**: compare(T o1, T o2)
- **Usage**: When you want to define multiple ways of comparing objects, or if you want to sort objects of a class that does not implement Comparable.

```java
import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName()); // Sorts by name
    }
}

```

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students, new NameComparator()); // Sorts by name
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }
    }
}

```