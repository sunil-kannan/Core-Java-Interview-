package utils;


// A class demonstrating pass by value or reference in Java
class Demo {
    // Method to modify the language attribute of a PassByValueOrReference object
    public void changingObjectValue(PassByValueOrReference object) {
        object.language = "Python"; // Changes the language attribute of the object to "Python"
    }
}

// Main class that contains examples of pass by value and pass by reference
public class PassByValueOrReference {
    String language = "Java"; // Default language attribute

    static PassByValueOrReference object = new PassByValueOrReference(); // Static instance of PassByValueOrReference

    // Method demonstrating pass by reference
    public void objectPassByReference() {
        System.out.println("Language value: " + object.language); // Prints: Java
        Demo demo = new Demo();
        demo.changingObjectValue(object); // Calls changingObjectValue method to change language to "Python"
        System.out.println("Language value after passing the reference: " + object.language); // Prints: Python
    }

    // Static method to demonstrate pass by value with a primitive type
    public static void changePrimitiveType(int age) {
        age = 20; // Changes the value of age locally to 20
    }

    // Static method to demonstrate pass by reference with an array
    public static void changeArrayValue(int[] a) {
        a[0] = 55; // Changes the first element of array a to 55
    }

    public static void main(String[] args) {
        object.objectPassByReference(); // Calls objectPassByReference method to demonstrate pass by reference
        int age = 22;
        System.out.println("Age value: " + age); // Prints: 22
        changePrimitiveType(age); // Calls changePrimitiveType to demonstrate pass by value
        System.out.println("Age Value after passing the value and not the reference: " + age); // Prints: 22

        int[] a = {2, 3, 4}; // Initializes an array a with values 2, 3, 4
        System.out.println("First value of Array a: " + a[0]); // Prints: 2
        changeArrayValue(a); // Calls changeArrayValue to demonstrate pass by reference with an array
        System.out.println("First value of Array a after passed in the method: " + a[0]); // Prints: 55
    }
}
