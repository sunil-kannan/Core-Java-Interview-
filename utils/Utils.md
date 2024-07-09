## Pass by Value and Pass by Reference in Java

### Primitive Types

When you pass a primitive type (like `int`, `float`, `char`, etc.) to a method in Java, you are passing a copy of the actual value stored in that variable. Here’s how it works:

- **Memory Location**: Primitive variables are stored directly in the stack memory.
- **Passing Mechanism**: When you pass a primitive type to a method, a copy of its value is passed.
- **Effect of Modifications**: Any changes made to the parameter inside the method do not affect the original variable outside the method.

```java
public class PassByValueExample {
    public static void main(String[] args) {
        int age = 25;
        changeAge(age);
        System.out.println("Age after method call: " + age); // Output: Age after method call: 25
    }

    public static void changeAge(int a) {
        a = 30; // Changes the local variable 'a', not affecting the original 'age'
    }
}
```

## Objects (including Arrays)

When you pass an object (or an array, which is also an object in Java) to a method, you are passing a copy of the reference to that object. Here’s how it works:

- **Memory Location**: Objects (including arrays) are stored in the heap memory.
- **Passing Mechanism**: When you pass an object to a method, a copy of its reference (address) is passed.
- **Effect of Modifications**: If the method modifies the object's state (like changing an element in an array), these modifications will be reflected in the original object outside the method. This is because the reference itself is passed by value.

```java
public class PassByReferenceExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        changeArray(numbers);
        System.out.println("First element after method call: " + numbers[0]); // Output: First element after method call: 10
    }

    public static void changeArray(int[] arr) {
        arr[0] = 10; // Modifies the first element of the array 'numbers'
    }
}
```
