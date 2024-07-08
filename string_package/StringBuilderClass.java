package string_package;

public class StringBuilderClass {
    String s2 = "code";
    public static void main(String[] args) {

        // Create an object
        StringBuilder sb1 = new StringBuilder("Hello");

        // Assign the reference to another variable
        StringBuilder sb2 = sb1;

        // Modify the object using one of the references
        sb2.append(" World");

        String s1 = new String("code");

        String s7;
        // Both references now point to the same modified object
        System.out.println(sb1); // Prints "Hello World"
        System.out.println(sb2); // Also prints "Hello World"
        System.out.println(sb1 == sb2); //true
    }
}
