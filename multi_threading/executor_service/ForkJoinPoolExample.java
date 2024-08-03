package multi_threading.executor_service;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample extends RecursiveTask<Integer> {
    final int n;
    ForkJoinPoolExample(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int n = 5, sol;
        ForkJoinPoolExample f1 = new ForkJoinPoolExample(n);
        sol = f1.compute();
        /**
         * Though it will be slow when you are handling with small amount of data, because the fork join pool creates
         * new object thus it takes some time to create object so it will not be efficient so think before twice while using this fork join pool
         */
        System.out.println("Answer: "+sol);

    }

    @Override
    protected Integer compute() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (n <= 1)
            return n;
        ForkJoinPoolExample f1 = new ForkJoinPoolExample(n - 1);
        f1.fork();
        ForkJoinPoolExample f2 = new ForkJoinPoolExample(n - 2);
        f2.fork();
        return f1.join() + f2.join();
    }

    private int doFibonacci() throws InterruptedException {
        if (n <= 1)
            return n;
        int a = -1, b = 1, sol = 0;
        for (int i = 0; i <= n; i++) {
            Thread.sleep(100);
            sol = a + b;
            a = b;
            b = sol;
        }
        return sol;
    }

}
