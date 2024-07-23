package multi_threading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronization {
    static int count = 0;

    private final Lock lock = new ReentrantLock();

    private static AtomicInteger counter = new AtomicInteger(0);

    public void unsynchronized(){
        count++;
    }
    public synchronized void incrementUsingSynchronized(){
        count++;
    }

    public synchronized void incrementUsingLock(){
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }
    }

    public void incrementUsingAtomicInteger(){
        counter.incrementAndGet();
    }

    public void accessingTwoThread(int method) throws Exception{
        Thread thread = new Thread(() ->{
            for(int i=0; i<1000; i++){
                switch (method){
                    case 1:
                        incrementUsingSynchronized();
                        break;
                    case 2:
                        incrementUsingLock();
                        break;
                    case 3:
                        incrementUsingAtomicInteger();
                        break;
                    default:
                        unsynchronized();
                }
            }
        });
        Thread thread1 = new Thread(() ->{
            for(int i=0; i<1000; i++){
                switch (method){
                    case 1:
                        incrementUsingSynchronized();
                        break;
                    case 2:
                        incrementUsingLock();
                        break;
                    case 3:
                        incrementUsingAtomicInteger();
                        break;
                    default:
                        unsynchronized();
                }
            }
        });
        thread1.start();
        thread.start();
        thread1.join();
        thread.join();
    }

    public static void main(String[] args) throws Exception {
        ThreadSynchronization object = new ThreadSynchronization();
        object.accessingTwoThread(1);
        System.out.println(count);
        count=0;
        object.accessingTwoThread(2);
        System.out.println(count);
        count =0;
        object.accessingTwoThread(3);
        System.out.println(counter);

        object.accessingTwoThread(4);
        System.out.println("Unsynchoronized count value: "+count);
    }

}
