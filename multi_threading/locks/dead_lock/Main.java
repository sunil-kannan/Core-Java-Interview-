package multi_threading.locks.dead_lock;

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
 *     <li>
 *         You can use ReentrantLock's tryLock() method with a timeout to prevent deadlocks.
 *     </li>
 * </ul>
 */
public class Main {

    public static void processThis(){

    }
    public static void processThat() {

    }
    public static void detectDeadLock(){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        boolean deadLock = threadIds !=null && threadIds.length > 0;
        System.out.println("------------ Dead locks found: "+deadLock+ " ----------------");
    }

    public static void makeDeadLock(Process process){
        if(process instanceof DeadLock) {
            System.out.println("----- Dead Lock class triggered. So deadlock is going to happen -----");
        }
        if(process instanceof TryLock){
            System.out.println("----- Try Lock class triggered. We are going to prevent deadlock using trylock with 1 second -----");
        }
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(process::processThis);
        service.execute(process::processThat);
        service.shutdown();
        try {
            Thread.sleep(2000);
            detectDeadLock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Process tryLock = new TryLock();
        makeDeadLock(tryLock);

        Thread.sleep(5000);
        Process deadLock = new DeadLock();
        makeDeadLock(deadLock);


    }
}
