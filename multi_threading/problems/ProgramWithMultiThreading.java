package multi_threading.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ProgramWithMultiThreading {

    // An AtomicInteger used to keep track of shared counts safely across threads.
    public static AtomicInteger counter = new AtomicInteger(0);

    public final static int n = 10000000; // 10 million
    public final static int numThreads = 10;
    public final static int rangePerThread = n / numThreads;

    public static void main(String[] args) {

        // This method calculates the result without using threads
        // Algorithm1 represents a sequential approach without parallel processing.
        // Example performance metrics: Time taken: 10000 ms, Result: 664579
        Algorithm1 algorithm1 = new Algorithm1(n);
        algorithm1.perform();

        // This method utilizes a fixed number of threads to process the range of numbers in parallel.
        // Algorithm2 divides the total range of numbers into equal-sized chunks and assigns each chunk to a separate thread.
        // This approach ensures that each thread works on a specific segment of the data, with the workload distributed evenly.
        /* The performance characteristics include:
              - **Chunk Allocation**: Each thread processes a predefined chunk of numbers. For example, if `n` is 10 million and `numThreads` is 10,
               each thread will handle a range of 1 million numbers.
              - **Thread Completion**: Threads might complete at different times based on the size of their assigned chunks. Threads assigned smaller ranges
               (lower numbers) may finish faster, while threads handling larger ranges (higher numbers) might take longer due to larger calculations.
        */
        // - **Time taken**: 3200 milliseconds (3.2 seconds) for completing the entire task with `numThreads` threads.
        Algorithm2 algorithm2 = new Algorithm2(n, numThreads);
        algorithm2.perform();


        // This method demonstrates dynamic thread allocation, where tasks are assigned to threads dynamically and
        // each thread will have equal amount of work but in case of Algorithm2 it differs. So that's why dynamic thread allocation is preffered for some cases.
        // Note: Dynamic thread allocation can introduce additional overhead due to task management,
        // which might make it slower compared to fixed thread allocation.
        // Example performance metrics: Time taken: 8000 ms
        Algorithm3 algorithm3 = new Algorithm3(n, numThreads);
        algorithm3.perform();


        // Algorithm2 is the best approach in this case, sometimes algorithm3 will be best suit for you, so check twice and use the best way

    }
}
