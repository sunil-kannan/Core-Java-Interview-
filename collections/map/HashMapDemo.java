package collections.map;

import java8_features.stream.Movie;
import java.util.*;

/**
 * Introduced in java 1.2
 * It is not thread safe and unsynchronized
 * Allows one null key
 * The ConcurrentModificationException is thrown when a HashMap is modified while it is being iterated over using an iterator
 */
public class HashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Movie> movies = new HashMap<>();
        movies.put(1, new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.put(2, new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.put(4, new Movie("Theri", 2016, "Vijay", "Atlee"));
        movies.put(3, new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        movies.put(null, new Movie("Theri", 2016, "Vijay", "Atlee"));
        Set<Integer> keys = movies.keySet();
        keys.forEach(System.out::println);

        /**
         * EntrySet provides a set of all the key-value pairs (entries) in a map, making it easy to iterate through both keys and values simultaneously.
         * EntrySet can be used with Java Stream API for various operations, such as filtering, mapping, and collecting.
         * EntrySet can be used to sort a map based on custom criteria using a comparator.
         */

//        List<Map.Entry<Integer, Movie>> list = new ArrayList<>(movies.entrySet());
//        Collections.sort(list, (o1, o2) -> o1.getValue().getYear() - o2.getValue().getYear());
//        list.forEach(sorted -> System.out.println(sorted.getKey() + " " + sorted.getValue()));
//        list.sort((o1, o2) -> o1.getValue().getName().compareTo(o2.getValue().getName()));
//        list.forEach(sorted -> System.out.println(sorted.getKey() + " " + sorted.getValue()));

        // using EntrySet you can change the value without having concurrent modification exception
        for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
            if (entry.getValue().getYear() < 2017) {
                Thread.sleep(200);
               entry.setValue(new Movie("Sarkar", 2014, "Vijay", "A.R. Murugadoss")); // Adding an entry will cause an exception
            }
        }



    }
}
