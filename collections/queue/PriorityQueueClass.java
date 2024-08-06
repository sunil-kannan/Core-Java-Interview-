package collections.queue;

import java8_features.stream.Movie;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * FIFO(First in first out) pattern
 * Only allow those generic types that are comparable which means class should implement comparable interface.
 */
public class PriorityQueueClass {
    public static void main(String[] args) {
        Queue<Movie> queue = new PriorityQueue<>();
        queue.add(new Movie("Mersal", 2017, "Vijay", "Atlee"));
        queue.add(new Movie("Bigil", 2019, "Vijay", "Atlee"));
        queue.add(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        queue.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        queue.poll(); // removes first element
        // Accessing the head of the PriorityQueue
        System.out.println("Head of the queue: " + queue.peek());
        System.out.println(queue);
    }
}
