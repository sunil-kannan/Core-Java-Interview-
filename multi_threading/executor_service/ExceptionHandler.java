package multi_threading.executor_service;

import java.util.concurrent.*;

public class ExceptionHandler{

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(
                5,
                50,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(40)); //A bounded queue to hold tasks before they are executed. Here, the queue can hold up to 65 tasks.

        // the blocking queue will hold only 40 task but the max pool size is 50, so 10 exception will occur (50-40 = 10)
        for(int i=0; i<100; i++){
            try{
                service.execute(() ->{
                    try {
                        Thread.sleep(100); // Simulate work
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }catch (RejectedExecutionException e){
                System.err.println("Task interrupted: " + e.getMessage());
            }
        }
        service.shutdown();

    }
}
