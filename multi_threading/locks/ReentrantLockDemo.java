package multi_threading.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant lock is unfair
 * <ul>
 *     <li>
 *         An unfair lock does not guarantee the order of lock acquisition.
 *     </li>
 *     <li>
 *         For example if 3 threads are waiting and 4th threads come in and lock the thread,
 *         where the 3 thread need to wait for the 4th thread to finish
 *     </li>
 *
 *     <li>
 *         If fairness is a requirement for your application, you can configure ReentrantLock to be fair by passing true to the constructor.
 *         ReentrantLock lock = new ReentrantLock(true)
 *     </li>
 * </ul>
 *
 * <p> Fair lock = Equal chance for all thread. Slower
 * <p> UnFair lock = Faster (more throughput). Thread starvation could be possible
 */
public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock fairLock = new ReentrantLock(true);
    private static int count = 0;

    public static void acccessResource() {
        System.out.println(Thread.currentThread().getName() + " Entered. Count = " + count);
        lock.lock();
        try {
            Thread.sleep(2000);
            count++;
            if (count == 1) {
                // If we call the same method, it will not acquire the lock again because it knows
                // that the current thread is the owner of the lock. This is why it is called a ReentrantLock.
                // you can see that one thread will be printed 2 times
                acccessResource();
            }

            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void lockWithTryLock() {
        try {
            // Try to acquire the lock without blocking
            if (lock.tryLock()) {
                try {
                    // Critical section
                    System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                    // Simulate some work
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
                    lock.unlock();
                }
            } else {
                // Lock not acquired, perform an alternative action
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, performing alternative action.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(ReentrantLockDemo::acccessResource);
            t.start();
        }

        for (int i = 11; i <= 13; i++) {
            Thread t1 = new Thread(ReentrantLockDemo::lockWithTryLock);
            t1.start();
        }


    }
}
