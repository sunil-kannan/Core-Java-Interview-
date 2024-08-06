package java8_features.utils;

import java.util.function.*;

public class Utils {
    public static void main(String[] args) {
        // Function: Convert a String to its length
        Function<String, Integer> stringLengthFunction = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLengthFunction.apply("Hello"));

        // Consumer: Print a message
        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("This is a message.");

        // Supplier: Provide a default value
        Supplier<String> defaultStringSupplier = () -> "Default Value";
        System.out.println("Supplier provides: " + defaultStringSupplier.get());

        // BiFunction: you can give two arguments and one return type
        BiFunction<String, String, Integer> concatenateFunction = (a, b) -> a.length() + b.length();
        System.out.println("Sum of the length of the both String: " + concatenateFunction.apply("Hello", "World!"));

        // BiPredicate: you can give two boolean functions
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a>0 && b>0;
        System.out.println("Both value should be more than 0: "+ biPredicate.test(3,0));

        // BiConsumer: that takes two arguments and prints them
        BiConsumer<String, Integer> printValue = (str, num) ->
                System.out.println("String: " + str + ", Integer: " + num);
        printValue.accept("Java", 1995);

        // Using andThen and compose with Function
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> doubleFunction = x -> x * 2;

        /**
         * The andThen method first applies the current function and then applies the specified function to the result.
         * In other words, andThen is used when you want the current function to be executed before the specified function.
         */
        Function<Integer, Integer> squareThenDouble = squareFunction.andThen(doubleFunction);
        System.out.println("Square then double of 3: " + squareThenDouble.apply(3)); // (3^2) * 2 = 18

        /**
         * The compose method first applies the specified function and then applies the current function to the result.
         * In other words, compose is used when you want the specified function to be executed before the current function.
         */
        Function<Integer, Integer> doubleThenSquare = squareFunction.compose(doubleFunction);
        System.out.println("Double then square of 3: " + doubleThenSquare.apply(3)); // (3*2)^2 = 36

    }
}
