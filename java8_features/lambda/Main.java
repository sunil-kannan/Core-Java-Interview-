package java8_features.lambda;

// Functional Interface with a single abstract method (SAM)
interface Operation {
    String doThis(String a, String b);
}

public class Main {
    public static void main(String[] args) {
        /*
         Lambdas can only be used with functional interfaces, which are interfaces with a single abstract method (SAM).
         Here, Operation is a functional interface.
         */

        //Using a lambda expression
        Operation operation = (a, b) -> a.concat(b);
        // Using a method reference
        Operation operation1 = String::concat;

        // Invoking the lambda expression and method reference
        System.out.println(operation.doThis("Java ", "Spring"));
        System.out.println(operation1.doThis("Java ", "Spring"));

    }

}
