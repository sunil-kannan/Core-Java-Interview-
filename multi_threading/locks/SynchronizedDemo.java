package multi_threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * A Java synchronized block marks a method or a block of code as synchronized.
 * A synchronized block in Java can only be executed a single thread at a time (depending on how you use it).
 * Java synchronized blocks can thus be used to avoid race conditions. This Java synchronized tutorial explains
 * how the Java synchronized keyword works in more detail.
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        Task demo = new Task();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 5; i++) {
            service.execute(demo);
        }
        service.shutdown();
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Entered");
        synchronized (this){
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}