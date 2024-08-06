## Java Collections and Data Structures

## Comparable and Comparator

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



## List

### Vector
- They are very similar to ArrayList, but Vector is synchronized and has some legacy methods that the collection framework does not contain.
- It also maintains an insertion order like an ArrayList. Still, it is rarely used in a non-thread environment as it is synchronized, and due to this, it gives a poor performance in adding, searching, deleting, and updating its elements.
- The Iterators returned by the Vector class are fail-fast. In the case of concurrent modification, it fails and throws the ConcurrentModificationException.

# Concurrent Modification

The `ConcurrentModificationException` in Java typically occurs when a collection is modified while it is being iterated over, and the collection’s iterator detects this change. This exception is part of the fail-fast behavior of certain collections.
## Synchronization vs. Fail-Fast Behavior

### Synchronization

- `Vector` is synchronized, which means it is thread-safe, and multiple threads can access it concurrently without causing data inconsistency.
- The synchronization ensures that operations on the `Vector` are atomic and visible to other threads.

### Fail-Fast Behavior

- Despite being synchronized, the iterators returned by `Vector` (and other similar collections) are fail-fast.
- This means that they check for structural modifications (i.e., additions or removals) to the collection during iteration.
- If a modification is detected while iterating, a `ConcurrentModificationException` is thrown.
- This mechanism is implemented to avoid subtle bugs and to ensure the integrity of the iteration process.

### Example
```java
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        Iterator<Integer> iterator = vector.iterator();

        // Start a thread that modifies the vector while it's being iterated
        new Thread(() -> {
            try {
                Thread.sleep(50); // Ensure that the iterator is in use
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vector.add(6);
        }).start();

        // Main thread continues iterating, this will throw ConcurrentModificationException
        while (iterator.hasNext()) {
            Thread.sleep(20);
            System.out.println(iterator.next());
        }
    }
}
```
### Output
```
1
2
Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.Vector$Itr.checkForComodification(Vector.java:1292)
	at java.base/java.util.Vector$Itr.next(Vector.java:1248)
	at collections.list.vectorandstack.VectorDemo.main(VectorDemo.java:32)```
```
## Why Fail-Fast Behavior Exists

### Iteration Integrity

- Fail-fast iterators are designed to detect concurrent modifications to ensure that the iteration process remains consistent.
- This helps in avoiding situations where the iterator might behave unpredictably due to changes made by other threads.

### Modification Detection

- The fail-fast behavior is not related to whether the collection itself is synchronized but rather to whether the structural modifications are detected during iteration.
- For `Vector`, any modification to its structure (like adding or removing elements) while iterating will lead to an exception if the iterator detects such changes.

### Collections with Fail-Fast Iterators

* **`ArrayList`**
* **`HashSet`**
* **`LinkedList`**
* **`TreeSet`**
* **`HashMap`**
* **`TreeMap`**

### Collections with Synchronized Wrappers

Some collections are synchronized, but they may still throw `ConcurrentModificationException` if you modify them during iteration:

* **`Vector`** (Synchronized, but can throw `ConcurrentModificationException`)
* **`Stack`** (Inherits from `Vector`, so it shares the same behavior)

### Collections with Fail-Safe Iterators

* **`CopyOnWriteArrayList`** (Does not throw `ConcurrentModificationException` but can have performance implications due to copying the array)
* **`CopyOnWriteArraySet`** (Similar behavior to `CopyOnWriteArrayList`)



