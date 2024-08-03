package multi_threading.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TypesOfPool {
    static class Task implements Runnable {

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        // Fixed Sized Thread Pool Executor
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("ExecutorService");
            }
        });
        executorService.shutdown();
        /*------------------------------------------------------------------------ */

        //Cached Thread Pool Executor
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("ExecutorService");
            }
        });
        executorService1.shutdown();
        /*------------------------------------------------------------------------ */

        //Scheduled Thread Pool Executor
        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(10);
        // task to run after 10 seconds delay
        service2.schedule(new Task(), 10, TimeUnit.SECONDS);
        // task to run repeatedly every 10 seconds
        service2.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);
        // task to run repeatedly 10 seconds after previous task completed
        service2.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

    }
}
