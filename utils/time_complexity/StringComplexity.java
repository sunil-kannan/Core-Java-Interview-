package utils.time_complexity;

import java.time.LocalDateTime;

public class StringComplexity {
    public static void main(String[] args) {
        int n = 1000;

        // Using a String
        String series = "";
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            series = series + (char) ('a' + i);
        }
        long endTime = System.nanoTime();
        // This will take more time because it creates 1000 objects,
        // as String is immutable and each concatenation creates a new object.
        System.out.println("Time taken with String: " + (endTime - startTime) / 1000000 + " ms");

        // Using a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stringBuilder.append((char) ('a' + i));
        }
        endTime = System.nanoTime();
        // StringBuilder does not take as much time because it is mutable and does not create a new object with each concatenation.
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) / 1000000 + " ms");
    }
}
