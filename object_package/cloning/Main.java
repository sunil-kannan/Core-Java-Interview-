package object_package.cloning;

import java.util.Arrays;
import java.util.Objects;

// Demo class implements Cloneable to support cloning
class Demo implements Cloneable {
    Integer age;
    String name;

    int[] arr;

    public Demo(Integer age, String name, int[] arr) {
        this.age = age;
        this.name = name;
        this.arr = arr;

    }

    // Copy constructor for creating a new Demo object from an existing one
    public Demo(Demo demo) {
        this.name = demo.name;
        this.age = demo.age;
        this.arr = demo.arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return Objects.equals(age, demo.age) && Objects.equals(name, demo.name) && Arrays.equals(arr, demo.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(age, name);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    // Override clone method to provide cloning functionality
    public Object cloneWithShallowCopy() throws CloneNotSupportedException {
         return super.clone();
    }
    public Object cloneWithDeepCopy() throws CloneNotSupportedException{
        Demo demo = (Demo) super.clone();
        int[] arr = new int[this.arr.length];
        System.arraycopy(this.arr, 0, arr, 0, this.arr.length);
        demo.arr=arr;
        return demo;
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1, 3, 64, 2, 4}; // Initialize an array of integers
        Demo demo = new Demo(17, "John", arr); // Create a new Demo object
        Demo demo2 = new Demo(demo); // Create a new Demo object using the copy constructor
        Demo demo3 = (Demo) demo.cloneWithShallowCopy(); // Clone the original Demo object

        // Compare objects using equals method and print results
        System.out.println(demo.equals(demo2)); // true (copied)
        System.out.println(demo.equals(demo3)); // true (cloned)

        // Print the array of the original object
        System.out.println(Arrays.toString(demo.arr)); // [1, 3, 64, 2, 4]

        // Modify the original object's properties
        demo.name = "Dhoni"; // Change the name
        demo.arr[1] = 40; // Change the second element of the array
        demo.age = 20; // Change the age

        System.out.println(demo3.arr[1]); // 40 (since the array reference was copied)
        /*
        References copied:
        The fields of the new object are copied, but if a field is a reference to another object, only the reference is copied, not the object itself.
        This could be avoided by using Deep copy
         */
        System.out.println(demo3.age); // 17 (age was cloned, not affected by change in the original object)

        // Create a new Demo object using deep copy
        Demo demo4 = (Demo) demo.cloneWithDeepCopy();
        demo.arr[0] = 100; // Modify the original object's array
        System.out.println(demo.arr[0]); // 100
        System.out.println(demo4.arr[0]); // 1 (deep copy ensures the original and clone are independent)
    }
}
