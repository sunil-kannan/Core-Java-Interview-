package multi_threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore in Java is a variable that is used to manage processes that run in parallel.
 * It is a non-negative variable that indicates the number of resources in the system that are available at a point in time.
 * By using counters, the semaphore controls the shared resources to ensure that threads running simultaneously
 * are able to access the resources and avoid race conditions.
 * Thus, the semaphore protects critical sections by using synchronized constructs.
 */
public class SemaphoreDemo {
    static class Task extends Thread implements Runnable {
        Semaphore sem;
        Task(Semaphore sem) {
            this.sem = sem;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting for a permit.");
            try {
                sem.acquire();
                System.out.println(Thread.currentThread().getName() + " gets a permit.");
                Thread.sleep(3000);
                sem.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<4; i++){
            executorService.execute(new Task(semaphore));
        }
        executorService.shutdown();
    }
}
