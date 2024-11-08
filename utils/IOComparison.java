package utils;

import java.io.RandomAccessFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IOComparison {
    public static void main(String[] args) throws IOException {
        int numWrites = 1000000;
        String fileName = "sequential_io.txt";
        String randomFileName = "random_io.txt";

        // Sequential I/O
        long startTime = System.nanoTime();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < numWrites; i++) {
                writer.write(i + "\n");
            }
        }
        long sequentialTime = System.nanoTime() - startTime;
        System.out.println("Sequential I/O time: " + TimeUnit.NANOSECONDS.toMillis(sequentialTime) + " ms");

        // Random I/O
        startTime = System.nanoTime();
        try (RandomAccessFile randomWriter = new RandomAccessFile(randomFileName, "rw")) {
            for (int i = 0; i < numWrites; i++) {
                randomWriter.seek((long) (Math.random() * numWrites * 10)); // random offset
                randomWriter.writeBytes(i + "\n");
            }
        }
        long randomTime = System.nanoTime() - startTime;
        System.out.println("Random I/O time: " + TimeUnit.NANOSECONDS.toMillis(randomTime) + " ms");

        // Print comparison
        System.out.println("Sequential I/O was " + (randomTime / sequentialTime) + " times faster");
    }
}
