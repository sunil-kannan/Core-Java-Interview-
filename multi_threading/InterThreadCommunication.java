package multi_threading;

/*
    This code demonstrates inter-thread communication in Java using the wait() and notify() methods for synchronization.
    It consists of a shared resource class (Q), a producer class (Producer), and a consumer class (Consumer).
    The producer and consumer threads interact with the shared resource in a coordinated manner, ensuring that the producer
    does not overwrite the value before the consumer reads it, and vice versa.
 */

class Q {
    int value; // The shared resource value
    boolean valueSet = false; // A flag indicating whether the value has been set

    public synchronized void getValue() {
        // Wait until the value is set
        while (!valueSet) {
            try {
                // When a thread calls wait() on an object, it releases the monitor for that object and enters the waiting state until another thread calls notify() or notifyAll() on the same object.
                wait(); // Release the lock and wait until notified
            } catch (Exception e) {
            }
        }
        System.out.println("Get: " + value);
        valueSet = false;
        // the notify() method is used to notify one of the threads that are waiting on the monitor of the object that called notify()
        notify(); // Notify the producer that the value has been consumed
    }

    // Method for the producer to set the value
    public synchronized void setValue(int value) {
        while (valueSet) {
            try {
                wait(); // Release the lock and wait until notified
            } catch (Exception e) {
            }
        }
        System.out.println("Consumer running");
        System.out.println("Put: " + value);
        this.value = value;
        valueSet = true;
        notify(); // Notify the consumer that a new value has been produced
    }
}

// Producer class
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        Thread thread = new Thread(this, "Producer");
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.setValue(i++); // Produce a new value
            try {
                Thread.sleep(1500);
                System.out.println("Producer running");
            } catch (Exception e) {
            }
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    Q q; // Reference to the shared resource

    Consumer(Q q) {
        this.q = q;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            q.getValue();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        Q q = new Q(); // Create the shared resource
        new Consumer(q); // Create and start the consumer thread
        new Producer(q); // Create and start the producer thread
    }
}
