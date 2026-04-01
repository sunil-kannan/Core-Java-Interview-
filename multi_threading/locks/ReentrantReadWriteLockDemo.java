package multi_threading.locks;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private final Set<Integer> set = new HashSet<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addElement(int value) {
        lock.writeLock().lock();
        try {
            set.add(value);
            System.out.println(Thread.currentThread().getName() + " added " + value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean containsElement(int value) {
        lock.readLock().lock();
        try {
            return set.contains(value);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo safeSet = new ReentrantReadWriteLockDemo();

        // Writer thread
        new Thread(() -> safeSet.addElement(42), "Writer").start();

        // Reader threads
        new Thread(() -> System.out.println("Reader1: " + safeSet.containsElement(42))).start();
        new Thread(() -> System.out.println("Reader2: " + safeSet.containsElement(42))).start();
    }

}


class UnsafeSetExample {
    private static final Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: continuously adds elements
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                set.add(i);
            }
        });

        // Thread 2: continuously checks contains()
        Thread reader = new Thread(() -> {
            for (int i = 20; i < 1_000; i++) {
                try {
                    Thread.sleep(6);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                set.contains(i);
            }
        });

        reader.start();
        writer.start();

        writer.join();
        reader.join();

        System.out.println("Final size: " + set.size());

}
}
