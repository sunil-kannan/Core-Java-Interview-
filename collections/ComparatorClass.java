package collections;

import java.util.*;

// Using Comparator (Multiple Sorting Criteria)
// With Comparator, you can define multiple ways to compare objects.
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.id - o2.id; // Compare students by their ID
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name); // Compare students by their name
    }
}

public class ComparatorClass {
    public static void main(String[] args) {
        Student[] studentArray = new Student[5];
        List<Student> studentsList = new ArrayList<>();

        // Initialize students
        studentArray[0] = new Student(3, "Sunil");
        studentArray[1] = new Student(7, "Sanjay");
        studentArray[2] = new Student(2, "Gopal");
        studentArray[3] = new Student(1, "Godson");
        studentArray[4] = new Student(7, "Bhai");

        // Add students to the list
        studentsList.add(studentArray[0]);
        studentsList.add(studentArray[1]);
        studentsList.add(studentArray[2]);
        studentsList.add(studentArray[3]);
        studentsList.add(studentArray[4]);

        // Sort the array using AgeComparator (by ID)
        Arrays.sort(studentArray, new AgeComparator());
        System.out.println(Arrays.toString(studentArray)); // Print sorted array by ID

        // Sort the array using NameComparator (by name)
        Arrays.sort(studentArray, new NameComparator());
        System.out.println(Arrays.toString(studentArray)); // Print sorted array by name

        // Sort the list using NameComparator (by name)
        Collections.sort(studentsList, new NameComparator());
        System.out.println(studentsList); // Print sorted list by name

        // Another method of sorting the list by ID reversing
        studentsList.sort(Comparator.comparingInt(Student::getId).reversed());
        System.out.println("Sorted by ID: " + studentsList);

        // Sorting the list first by ID, then by name
        studentsList.sort(Comparator.comparingInt(Student::getId).thenComparing(Student::getName));
        System.out.println("Sorted by ID, then by name: " + studentsList);

        // Additional method to compare: using lambda expressions
        studentsList.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
        System.out.println("Sorted by ID using lambda: " + studentsList);

        // Another method: using method reference for comparing by name
        studentsList.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name using method reference: " + studentsList);



        // like this you can have the function within the same class
        Comparator<Student> comparator = (o1, o2) -> {
            if(o1.id > o2.id){
                return 1;
            }
            else if(o1.id == o2.id){
                if(o2.name.length() > o1.name.length()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            return -1;
        };

        Comparator<Student> comparator1 = (v1, v2 ) -> v1.id - v2.id;

        studentsList.sort(comparator);
        studentsList.sort(comparator1);

    }
}
