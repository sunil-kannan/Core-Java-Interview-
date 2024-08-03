package multi_threading.executor_service.completable_future;

import java.util.concurrent.*;

class Employee {
    private int roll_no;
    private String name;
    @Override
    public String toString() {
        return "Employee{" +
                "roll_no=" + roll_no +
                ", name='" + name + '\'' +
                '}';
    }
    public Employee(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}

public class RunAsync {

    public static Void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name: " + Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
                Employee employee = new Employee(1, "John"); // Create a new Employee object
                System.out.println(employee.toString()); // Print the employee details
            }
        });
        return completableFuture1.get();// it will return only Void, it will be null
    }
    public static void runAsyncWithExecutorService() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // Create a CompletableFuture that runs asynchronously using the provided executorService
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName()); // pool-1-thread-1
            Employee employee = new Employee(1, "John");
            System.out.println(employee.toString());
        }, executorService);
        // Optional: Shut down the executor service to free up resources
        executorService.shutdown();
        // Optionally, wait for the termination of the executor service
        executorService.awaitTermination(1, TimeUnit.MINUTES); // Adjust the timeout as needed
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsync();
        runAsyncWithExecutorService();
    }
}
