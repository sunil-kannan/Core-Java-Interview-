package multi_threading.java_memory_model;

/*
The visibility problem in Java arises in multi-threaded applications. It occurs when one thread modifies a shared variable,
but other threads are not immediately aware of the change. This happens because each thread may have its own cached copy
of the variable, and updates to the shared variable might not be reflected in these caches immediately.
 */
public class VisibilityProblem {
    private static boolean flag = false;
    private static int i=5;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    // the loop will continuously run, thread1 might not see the change made by thread2 immediately
                    // Solution: By making the flag variable volatile
                     i = 4;
                }
                System.out.println("Flag is now true!");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // Wait for 1 second
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                // thread1 being stuck in an infinite loop, even though thread2 has set the flag to true.
                flag = true;
                System.out.println("Flag set to true!");
            }
        });

        thread1.start();
        thread2.start();
    }
}
