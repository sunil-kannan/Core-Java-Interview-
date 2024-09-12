package multi_threading;

import static java.lang.Thread.sleep;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        // Define a Runnable that prints "Running" every second
        Runnable runnable = () -> {
            while (true) {
                try {
                    sleep(1000); // Sleep for 1 second
                    System.out.println("Running");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Create a new Thread with the defined Runnable
        Thread thread = new Thread(runnable);

        // Set the thread as a daemon thread
        // When you set a thread as a daemon thread in Java by calling thread.setDaemon(true), it means that the thread will run in the background and will not prevent the JVM from exiting.
        // The JVM will terminate when all non-daemon threads have finished, even if there are still daemon threads running.
        thread.setDaemon(true);

        // Uncommenting the line below would reset the thread as a user thread (non-daemon)
        // thread.setDaemon(false);

        // Start the thread
        thread.start();
        /**
         * You can't set the thread as Daemon after the thread starts
         */

        // Main thread sleeps for 3.1 seconds (3100 milliseconds)
        // After 3.1 seconds, the main thread will finish, and if the 'thread' is a daemon,
        // it will be terminated as well. If the 'thread' is not a daemon, it will continue to run.
        sleep(3100);

        /*
        After the main thread finishes sleeping, it will exit,and if the worker thread is a daemon,
        it will also terminate.If the worker thread is not a daemon, it will keep running indefinitely.
        */

    }
}
