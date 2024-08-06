package java8_features.utils;

import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        Predicate<String> predicates = s -> s.length() > 5;
        System.out.println("The length of the String is greater than 5 :"+predicates.test("Java Language"));

        // Define predicates
        Predicate<Integer> isDivisibleBy3 = s -> (s % 3 == 0);
        Predicate<Integer> isDivisibleBy2 = s -> (s % 2 == 0);
        Predicate<Integer> isDivisibleBy4 = s -> (s % 4 == 0);

        // Combine predicates
        Predicate<Integer> isDivisibleBy3And2 = isDivisibleBy3.and(isDivisibleBy2);
        Predicate<Integer> isDivisibleBy3Or4 = isDivisibleBy3.or(isDivisibleBy4);
        Predicate<Integer> isNotDivisibleBy2 = isDivisibleBy2.negate();

        // Test combined predicates
        int testNumber = 18;

        System.out.println("Testing number: " + testNumber);
        System.out.println("Is divisible by 3 and 2: " + isDivisibleBy3And2.test(testNumber)); // true
        System.out.println("Is divisible by 3 or 4: " + isDivisibleBy3Or4.test(testNumber));   // true
        System.out.println("Is not divisible by 2: " + isNotDivisibleBy2.test(testNumber));    // false

        // Additional example with multiple combinations
        Predicate<Integer> complexPredicate = isDivisibleBy3.and(isDivisibleBy2.or(isDivisibleBy4)).negate(); // negate will return the opposite
        System.out.println("Complex predicate result: " + complexPredicate.test(testNumber));  // false

    }
}
