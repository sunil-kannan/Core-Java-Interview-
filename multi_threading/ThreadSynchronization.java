package multi_threading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronization {
    static int count = 0;
    private static final Lock lock = new ReentrantLock();
    private static AtomicInteger counter = new AtomicInteger(0);
    private static void unsynchronized() {
        count++;
    }
    private synchronized static void incrementUsingSynchronized() {
        count++;
    }
    private static synchronized void incrementUsingLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    private static void incrementUsingAtomicInteger() {
        counter.incrementAndGet();
    }
    private static void runThreads(Runnable task) throws InterruptedException {
        Thread thread1 = new Thread(createTask(task));
        Thread thread2 = new Thread(createTask(task));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static Runnable createTask(Runnable task) {
        return () -> {
            for (int i = 0; i < 100000; i++) {
                task.run();
            }
        };
    }

    public static void main(String[] args) throws Exception {

        runThreads(ThreadSynchronization::unsynchronized);
        System.out.println("Unsynchronized count: " + count);
        // Reset count
        count = 0;

        // Run synchronized example
        runThreads(ThreadSynchronization::incrementUsingSynchronized);
        System.out.println("Synchronized count: " + count);
        count = 0;

        // Run synchronized example
        runThreads(ThreadSynchronization::incrementUsingLock);
        System.out.println("Increment using Lock: " + count);

        // Run synchronized example
        runThreads(ThreadSynchronization::incrementUsingAtomicInteger);
        System.out.println("Count using Atomic Integer: " + counter);
    }

}
