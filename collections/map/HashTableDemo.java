package collections.map;

import java8_features.stream.Movie;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


/**
 * Since java was introduced
 * It is thread safe and synchronized
 * Does not allow null key
 * The ConcurrentModificationException is thrown when a HashMap is modified while it is being iterated over using an iterator
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Map<Integer, Movie> movies = new Hashtable<>();
        movies.put(1, new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.put(2, new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.put(4, new Movie("Theri", 2016, "Vijay", "Atlee"));
        movies.put(3, new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        Set<Integer> keys = movies.keySet();
        keys.forEach(System.out::println);

    }
}
