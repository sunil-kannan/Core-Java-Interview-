package multi_threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * A mutex is owned by a thread that locks it, meaning only the thread that locks (acquires) the mutex can unlock (release) it.
 * A mutex has two states: locked or unlocked. It allows only one thread at a time to access a shared resource, enforcing mutual exclusion.
 * You can use mutex with any type of lock (Semaphore, Reentrant, etc.)
 */
    class CounterUsingMutex {
        public int count = 0;
        private Semaphore mutex;
        public CounterUsingMutex() {
            this.mutex = new Semaphore(1);
        }
        public void increase() throws InterruptedException {
            mutex.acquire();
            Thread.sleep(200);
            this.count = this.count + 1;
            System.out.println("Count: " + count);
            mutex.release();
        }
    }

public class MutexDemo {
    public static void main(String[] args) {
        int count = 5;
        ExecutorService executorService
                = Executors.newFixedThreadPool(count);
        CounterUsingMutex counter = new CounterUsingMutex();
        CounterUsingMutex counter1 = new CounterUsingMutex();
        IntStream.range(0, count)
                .forEach(user -> executorService.execute(() -> {
                    try {
                        counter.increase();
                        counter1.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
