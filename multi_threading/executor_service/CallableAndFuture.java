package multi_threading.executor_service;

import java.util.*;
import java.util.concurrent.*;

public class CallableAndFuture {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            return 4;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with lambda expression
        ExecutorService service1= Executors.newFixedThreadPool(1);
        Future<List> futureValue = service1.submit(() ->{
            return Arrays.asList("1","2");
        });
        System.out.println(futureValue.get()); // [1, 2]

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Integer>> allFuture = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
                Future<Integer> future = service.submit(new Task());
                allFuture.add(future);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            try {
                // the main thread will go into the block state in case if thread is not completed, and once if completed the main thread will resume
                Future<Integer> future = allFuture.get(i);
                System.out.println(future);
                // Wait for the result, with a timeout of 1 second. If the task exceeds 1 second, a TimeoutException is thrown.
                Integer result = future.get(1, TimeUnit.SECONDS);
                System.out.println(result);
            } catch (InterruptedException e) {
                System.err.println("Task interrupted: " + e.getMessage());
            } catch (ExecutionException e) {
                System.err.println("Task execution exception: " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("Timeout Exception: Task " + (i + 1) + " took too long to complete.");
            }
        }
        service.shutdown();
    }
}
