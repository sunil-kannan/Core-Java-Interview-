package java8_features.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

public class IntStreamClass {

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(n -> number % n == 0);
    }

    public static void main(String[] args) {
        Integer i = 39;
        System.out.println("hash"+i.hashCode());
        i = 28;
        System.out.println(i.hashCode());

        System.out.println(isPrime(5));
        List<Double> sqrtOf10Prime = Stream.iterate(1, integer -> integer + 1)
                .filter(IntStreamClass::isPrime)
                .peek(System.out::println)
                .map(Math::sqrt)
                .limit(10)
                .collect(Collectors.toList());

//        IntStream.range(1, 10)

        System.out.println(sqrtOf10Prime);
        String A = "AB, CD,EF";
        String B = " DE F AB C ";
        String[] elements =A.split(",",4);
        System.out.println(elements[1]);
        System.out.println(B.trim());
    }
}
