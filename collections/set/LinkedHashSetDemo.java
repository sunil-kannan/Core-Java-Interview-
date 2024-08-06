package collections.set;

import java8_features.stream.Movie;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements.
 * When the iteration order is needed to be maintained this class is used.
 * LinkedHashSet allow null elements
 * When iterating through a HashSet the order is unpredictable, while a LinkedHashSet lets us iterate through the elements in the order in which they were inserted.
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<Movie> movies = new LinkedHashSet<>();
        movies.add(new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.add(new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.add(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        movies.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        movies.add(null);
        movies.forEach(x -> System.out.println(x.toString()));
    }
}
