package multi_threading.problems;


class ThreadTask implements Runnable {
    private final int start;
    private final int end;

    ThreadTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        if ((c * c) > n) {
            ProgramWithMultiThreading.counter.incrementAndGet();
        }
        return true;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            isPrime(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Thread " + Thread.currentThread().getName() + " has completed processing range " + start + " to " + end + "with in "+(endTime - startTime) / 1_000_000+" milli seconds");
    }
}