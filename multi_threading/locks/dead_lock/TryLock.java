package multi_threading.locks.dead_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Process{

    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();
    @Override
    public void processThis() {
        try {
            if (lockA.tryLock(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("processThis : LockA.lock");
                Thread.sleep(200);
                try {
                    if (lockB.tryLock(1000, TimeUnit.MILLISECONDS)) {
                        System.out.println("processThis : LockB.lock");
                        try {
                            // Critical section
                        } finally {
                            lockB.unlock();
                            System.out.println("processThis : LockB.unlock");
                        }
                    }
                } finally {
                    lockA.unlock();
                    System.out.println("processThis : LockA.unlock");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processThat() {
        try {
            if (lockB.tryLock(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("processThat : LockB.lock");
                try {
                    if (lockA.tryLock(1000, TimeUnit.MILLISECONDS)) {
                        System.out.println("processThat : LockA.lock");
                        try {
                            // Critical section
                        } finally {
                            lockA.unlock();
                            System.out.println("processThat : LockA.unlock");
                        }
                    }
                } finally {
                    lockB.unlock();
                    System.out.println("processThat : LockB.unlock");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
