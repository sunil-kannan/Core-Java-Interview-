package multi_threading.executor_service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class CpuIntensiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Main {
//    static
    public static void main(String[] args) throws InterruptedException {
        // get count of available cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        // If your CPU has 4 cores means, 4 threads can run at a same time.
        for(int i=0; i<50; i++){
            service.execute(new CpuIntensiveTask());
        }
        // it will intiate the shutdown but it will complete all the task
        service.shutdown();

        System.out.println(service.isShutdown()); // true
        System.out.println(service.isTerminated()); // false

        // it will return all the task that were queued but the execution will not be initiated
        List<Runnable> runnableList = service.shutdownNow();
        System.out.println("Runnable List size: "+runnableList.size());

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("ExecutorService");
            }
        });
        executorService.shutdown();


    }
}
