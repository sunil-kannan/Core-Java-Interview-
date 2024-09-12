package multi_threading.locks;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 *     <h3>How to avoid Dead locks
 *     <li>
 *         One of the most effective ways to avoid deadlock is to establish a consistent order in which locks are acquired. Ensure that all threads acquire the locks in the same order.
 *     </li>
 * </ul>
 */
public class DeadLockDemo {
    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();
    public static void processThis(){
        try {
            System.out.println("processThis 1");
            lockA.lock();
            Thread.sleep(100);
            System.out.println("processThis 2");
            lockB.lock();
            System.out.println("processThis 3");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockA.unlock();
        lockB.unlock();
    }
    public static void processThat() {
        System.out.println("processThat 1");
        lockB.lock();
        System.out.println("processThat 2");
        lockA.lock();
        System.out.println("processThat 3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockB.unlock();
        lockA.unlock();
    }
    public static void detectDeadLock(){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        boolean deadLock = threadIds !=null && threadIds.length > 0;
        System.out.println("Dead locks found: "+deadLock);
    }

    public static void makeDeadLock(){
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(DeadLockDemo::processThis);
        service.execute(DeadLockDemo::processThat);
        service.shutdown();
        try {
            Thread.sleep(2000);
            detectDeadLock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void avoidDeadLockWithTryLock(){

    }

    public static void main(String[] args) {
       makeDeadLock();

    }
}
