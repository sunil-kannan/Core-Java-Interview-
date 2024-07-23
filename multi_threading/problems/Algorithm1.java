package multi_threading.problems;

public class Algorithm1 {
    int n;
    Algorithm1(int n){
        this.n = n;
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

    public void perform(){
        long startTime = System.nanoTime();
        for(int i=1; i<n; i++){
            isPrime(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println("Total Prime number: "+ProgramWithMultiThreading.counter);
    }
}
