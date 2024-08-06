package collections.set;

import java8_features.stream.Movie;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet class contains unique elements only like HashSet.
 * TreeSet doesn't allow null element
 * TreeSet can only allow those generic types that are comparable which means class should implement comparable interface.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Movie> movies = new TreeSet<>();
        movies.add(new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.add(new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.add(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        movies.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        // movies.add(null);
        movies.forEach(x -> System.out.println(x.toString()));
    }
}
