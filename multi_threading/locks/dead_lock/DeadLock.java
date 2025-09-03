package multi_threading.locks.dead_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock implements Process{
    private static final Lock lockA = new ReentrantLock();
    private static final Lock lockB = new ReentrantLock();
    @Override
    public void processThis() {
        try {

            lockA.lock();
            System.out.println("processThis : LockA.lock");
            Thread.sleep(100);
            lockB.lock();
            System.out.println("processThis : LockB.lock");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockA.unlock();
        lockB.unlock();
    }

    @Override
    public void processThat() {
        lockB.lock();
        System.out.println("processThat : LockB.lock");
        lockA.lock();
        System.out.println("processThat : LockA.unlock");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockB.unlock();
        lockA.unlock();
    }
}
