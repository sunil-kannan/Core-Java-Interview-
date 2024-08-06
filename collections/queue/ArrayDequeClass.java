package collections.queue;

import java8_features.stream.Movie;
import java.util.ArrayDeque;

/**
 * Suitable for scenarios where you need to perform operations at both ends of the deque (double-ended queue),
   like adding or removing elements from the front or back.
 * Does not maintain any specific order of elements based on their values.
 */
public class ArrayDequeClass {
    public static void main(String[] args) {
        ArrayDeque<Movie> movies = new ArrayDeque<>();
        movies.add(new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.add(new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.add(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        movies.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        movies.removeFirst(); // removes first element
        movies.removeLast(); // removes last element
        System.out.println(movies);

    }
}
