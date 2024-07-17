# Java: Pass by Value or Pass by Reference?

Java is strictly a "pass-by-value" language. However, this can be somewhat confusing because of the way it handles object references.

### Explanation

1. **Primitive Data Types**:
   For primitive data types (such as `int`, `float`, `char`, etc.), Java copies the actual value. Any changes made to the parameter within the method do not affect the original variable.

   ```java
   public static void main(String[] args) {
       int a = 10;
       modifyPrimitive(a);
       System.out.println(a); // Output: 10
   }
   
   public static void modifyPrimitive(int x) {
       x = 20;
   }
   
2. **Object References**:
   For objects, Java still passes by value, but the value is a reference to the object. This means that while the reference itself is copied, both the original and the copied reference point to the same object. Therefore, changes made to the object through the copied reference will be reflected when accessed through the original reference.

    ```java
    public static void main(String[] args) {
    MyObject obj = new MyObject();
    obj.value = 10;
    modifyObject(obj);
    System.out.println(obj.value); // Output: 20
    }

    public static void modifyObject(MyObject o) {
    o.value = 20;
    }

    static class MyObject {
    int value;
    }

    ```
2. **Reference Reassignment**:
   However, if you reassign the reference inside the method, the original reference remains unchanged.

    ```java
    public static void main(String[] args) {
    MyObject obj = new MyObject();
    obj.value = 10;
    reassignObject(obj);
    System.out.println(obj.value); // Output: 10
    }

    public static void reassignObject(MyObject o) {
    o = new MyObject();
    o.value = 20;
    }

   ```
   In this example, obj.value remains 10 because the reassignObject method creates a new object and changes the reference to point to this new object. The original reference obj still points to the original object.