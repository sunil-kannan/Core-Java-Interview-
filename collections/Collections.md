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
- List is a collection of homogeneous and heterogeneous
- List class maintains insertion order


### ArrayList
- ArrayList having index and index starts with 0.
- Java ArrayList class uses a dynamic array for storing the elements. It is like an array, but there is no size limit.

### LinkedList
- Manipulation is fast because no shifting needs to occur.

### Vector
- They are very similar to ArrayList, but Vector is synchronized and has some legacy methods that the collection framework does not contain.
- It also maintains an insertion order like an ArrayList. Still, it is rarely used in a non-thread environment as it is synchronized, and due to this, it gives a poor performance in adding, searching, deleting, and updating its elements.
- The Iterators returned by the Vector class are fail-fast. In the case of concurrent modification, it fails and throws the ConcurrentModificationException.

### Stack 
- Stack is a data structure which posses LIFO (Last In First Out).
- `object.pop()` will remove the last element.


## Queue
- The Queue is also called as FIFO (First in First Out).

### Priority Queue
- FIFO(First in first out) pattern
- Only allow those generic types that are comparable which means class should implement comparable interface.

### ArrayDeque
- FIFO and LIFO
- Suitable for scenarios where you need to perform operations at both ends of the deque (double-ended queue),
  like adding or removing elements from the front or back.
- ArrayDeque implements `Deque` interface

## Set
### HashSet
- Insertion order is not preserved.
- Hashset cannot allow duplicate values.
- Hashset allow one null values.

### LinkedHashSet
- It uses a hashtable & a doubly-linked list to store & maintain the elements.
- It allows an easy way to maintain the insertion order.

### TreeSet
- TreeSet class contains unique elements only like HashSet.
- TreeSet doesn't allow null element.
- TreeSet can only allow those generic types that are comparable which means class should implement comparable interface.

## Map
- A Map is a collection of key/value pairs that can use any data type as a key and can maintain the order of its entries.
- Map doesn't allow duplicate keys, but it allows duplicate values. 
- HashMap and LinkedHashMap allows null keys and null values but TreeMap doesn't allow any null key or value.

### HashMap
- HashMaps are not ordered, which means that the order in which elements are added to the map is not preserved.
- HashMaps uses a hash function to map keys to indices in an array. This allows for a quick lookup of values based on keys.
- HashMaps allow for duplicate values, but not duplicate keys. If a duplicate key is added, the previous value associated with the key is overwritten.
- HashMaps allow for null values and keys. This means that a null key can be used to store a value, and a null value can be associated with a key.
- HashMaps are not thread-safe, which means that if multiple threads access the same hashmap simultaneously, it can lead to data inconsistencies. If thread safety is required, ConcurrentHashMap can be used.

### HashTable
- Does not allow null key
- It is thread safe and synchronized

### LinkedHashMap
- It is the same as HashMap with an additional feature that it maintains insertion order.

### TreeMap
- Only allows keys of generic types that are comparable, meaning the class should implement the Comparable interface.
- By using TreeMap the order will be preserved but in Hashmap it may or may not preserve the order.
- Does not allow null key

## Collections That Need `Comparator` or `Comparable`:

1. **Sorted Collections**: Collections that maintain a sorted order require either a `Comparator` or `Comparable`. These include:

    - **`TreeSet`**: This is a sorted set. It needs either the elements to implement `Comparable` or a `Comparator` to determine the order of the elements.
    - **`TreeMap`**: This is a sorted map. It requires the keys to be `Comparable` or a `Comparator` to order the keys.
    - **`PriorityQueue`**: This is a queue with priority. It needs either the elements to implement `Comparable` or a `Comparator` to determine the priority.

2. **Non-Sorted Collections**: Collections that do not enforce any order or sorting do not need a `Comparator` or `Comparable`:

    - **`ArrayList`**: No sorting or ordering by default.
    - **`LinkedList`**: No sorting or ordering by default.
    - **`HashSet`**: No sorting or ordering by default.
    - **`HashMap`**: No sorting or ordering by default.
    - **`LinkedHashSet`**: Maintains insertion order but does not sort elements.

### Quick Mnemonics:

- **"Tree and Priority"**: If the collection name includes "Tree" or "Priority", it needs a `Comparator` or `Comparable`.
- **"Order vs. No Order"**: Collections with built-in order or sorting mechanisms (like `TreeSet` and `PriorityQueue`) need a way to define this order. Collections without such mechanisms (like `ArrayList` and `HashSet`) do not.

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

## Collections and Null Handling

### Collections that do not allow `null` keys:

* **PriorityQueue**: Does not allow `null` elements if a comparator is used that does not handle `null`.
* **TreeMap**: Does not allow `null` keys if a comparator is used that does not handle `null`.
* **TreeSet**: Does not allow `null` elements if a comparator is used that does not handle `null`.
* **ConcurrentSkipListSet**: Does not allow `null` elements.

### Collections that do not allow `null` values:

* **ConcurrentSkipListSet**: Does not allow `null` elements.
* **EnumSet**: Does not allow `null` elements.

### Collections that do not allow both `null` keys and `null` values:
* **ConcurrentHashMap**: Does not allow `null` keys or values.
* **Hashtable**: Does not allow `null` keys or values. The design choice to disallow null was partly due to early implementations of hash tables that were not robust in handling null values.

## Additional Notes

### Collections that handle `null` values with special considerations:
* **PriorityQueue**: Handles `null` values if the comparator permits it.
* **TreeMap/TreeSet**: Handles `null` keys if the comparator permits it.
