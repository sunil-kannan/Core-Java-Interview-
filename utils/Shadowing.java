package utils;
/*
Variable Shadowing occurs when a variable declared within a certain scope (e.g., a local variable)
has the same name as a variable declared in an outer scope (e.g., a class-level variable).
The variable in the inner scope "shadows" the variable in the outer scope, meaning that within the inner scope,
only the inner variable is accessible by that name.
 */

public class Shadowing {

    static int a = 10; // This is a static variable 'a' with a value of 10

    public static void main(String[] args) {
        System.out.println(a); // Prints 10, accessing the static variable 'a'
        int a; // This declares a local variable 'a' within the main method, shadowing the static variable
        a = 20;
        System.out.println(a);
        fun();
    }

    static void fun(){
        System.out.println(a); // Prints 10, accessing the static variable 'a' because the local 'a' in main() is out of scope
    }
}
