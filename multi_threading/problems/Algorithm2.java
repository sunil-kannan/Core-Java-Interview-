package multi_threading.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Algorithm2 {
    int n;
    int numThreads;
    int rangePerThread ;
    Algorithm2(int n, int numThreads){
        this.n = n;
        this.numThreads = numThreads;
        this.rangePerThread = n / numThreads;
    }
    public void perform(){
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < numThreads; i++) {
            int firstParam = (i * rangePerThread) + 1;
            int secondParam = (i + 1) * rangePerThread;
            executorService.submit(new ThreadTask(firstParam, secondParam));
        }
        // Shut down the executor service
        executorService.shutdown();

        try {
            // Wait for all tasks to complete or timeout after 1 hour
            if (executorService.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("All tasks completed.");
                long endTime = System.nanoTime();
                System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
            } else {
                System.out.println("Timeout occurred before all tasks completed.");
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread was interrupted while waiting.");
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
