package multi_threading.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Algorithm3 {
    int n;
    int numThreads;
    int rangePerThread;

    Algorithm3(int n, int numThreads) {
        this.n = n;
        this.numThreads = numThreads;
        this.rangePerThread = n / numThreads;
    }


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        if ((c * c) > n) {
            ProgramWithMultiThreading.counter.incrementAndGet();
        }
        return true;
    }

    public void perform() {
        long startTime = System.nanoTime();
        // Create an ExecutorService with a fixed thread pool of 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        for (int i = 1; i < n; i++) {
            final int value = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    isPrime(value);
//                    System.out.println("Thread " + Thread.currentThread().getName() + " processed value " + value );
                }
            });
        }
        executorService.shutdown();

        try {
            // Wait for all tasks to complete or timeout after 1 hour

            if (executorService.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("All tasks completed.");
                long endTime = System.nanoTime();
                System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
                System.out.println("Total Prime number: "+ProgramWithMultiThreading.counter);
            } else {
                System.out.println("Timeout occurred before all tasks completed.");
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread was interrupted while waiting.");
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}

