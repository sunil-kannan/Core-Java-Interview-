package collections.list.vectorandstack;

import java.util.*;

/**
 * Vector is like ArrayList, but it is synchronized.
 * Only one thread can modify or insert the data.
 * And due to this, it gives a poor performance in adding, searching, deleting, and updating its elements.
 */
public class VectorDemo {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        Iterator<Integer> iterator = vector.iterator();

        /**
         * Vector is synchronized, but it will throw concurrent modification exception
         */
        // Start a thread that modifies the vector while it's being iterated
        new Thread(() -> {
            try {
                Thread.sleep(50); // Ensure that the iterator is in use
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vector.add(6);
        }).start();

        // Main thread continues iterating, this will throw ConcurrentModificationException, to know more refer Collections.md file in the list folder
        while (iterator.hasNext()) {
            Thread.sleep(20);
            System.out.println(iterator.next());
        }


    }
}
