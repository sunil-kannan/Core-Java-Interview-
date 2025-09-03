package multi_threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final BlockingQueue<Runnable> taskQueue;
    CustomThreadPool(int nThreads){
        this.nThreads = nThreads;
        this.taskQueue = new LinkedBlockingDeque<>();
        this.threads = new PoolWorker[nThreads];
        for(int i=0; i<nThreads; i++){
            threads[i] = new PoolWorker();
            threads[i].start();
        }
        System.out.println("initialization completed");
    }

    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdown() throws InterruptedException {
        for (PoolWorker worker: threads){
            worker.stopWorker();
        }
        for(PoolWorker worker: threads){
            worker.join();
        }
    }

    private class PoolWorker extends Thread{
        private volatile boolean running = true;
        private void stopWorker(){
            this.running = false;
        }

        @Override
        public void run() {
            while (running){
                try{
                    // the take() method will block until an item becomes available in the queue. Thus it prevents infinite looping
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(5);
        for (int i=0; i<25; i++){
            final int task = i;
            customThreadPool.execute(() -> {
                System.out.println("Task "+task+" by "+Thread.currentThread().getName());
                try {
                    if(task==15){
                        customThreadPool.shutdown();
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}
