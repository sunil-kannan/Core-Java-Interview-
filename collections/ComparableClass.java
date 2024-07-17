package collections;

import java.util.Arrays;
import java.util.Comparator;

// Student class implementing Comparable interface for natural ordering
class Student implements Comparable<Student> {
    int id;
    String name;

    // Constructor to initialize Student objects
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter methods for id and name
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Overriding toString method to print student details
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Overriding compareTo method for natural ordering (by id and name length)
    @Override
    public int compareTo(Student o) {
        if (o.id < this.id) {
            return 1;
        } else if (o.id == this.id) {
            if (o.name.length() > this.name.length()) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}

public class ComparableClass {
    public static void main(String[] args) {
        Student[] studentArray = new Student[5];

        // Initializing student array
        studentArray[0] = new Student(3, "Sunil");
        studentArray[1] = new Student(7, "Sanjay");
        studentArray[2] = new Student(2, "Gopal");
        studentArray[3] = new Student(1, "Godson");
        studentArray[4] = new Student(7, "Bhai");

        // Sorting the array using natural ordering (compareTo method)
        Arrays.sort(studentArray);
        System.out.println(Arrays.toString(studentArray));

        // Using a lambda expression to sort the array by id in descending order
        Arrays.sort(studentArray, (v1, v2) -> v2.id - v1.id);
        System.out.println(Arrays.toString(studentArray));


        // Using Comparator.comparing for more flexible comparisons
        Arrays.sort(studentArray, Comparator.comparing(Student::getId).reversed());
        System.out.println(Arrays.toString(studentArray));

        // Using multiple criteria for sorting: first by id, then by name
        Arrays.sort(studentArray, Comparator.comparingInt(Student::getId).thenComparing(Student::getName));
        System.out.println(Arrays.toString(studentArray));

        // Using method references for more readable code
        Arrays.sort(studentArray, Comparator.comparing(Student::getId));
        System.out.println(Arrays.toString(studentArray));
    }
}
