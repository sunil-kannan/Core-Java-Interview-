package collections.set;

import java8_features.stream.Movie;
import java.util.HashSet;

/**
 * HashSet will not allow duplicate
 * HashSet will not preserve the order
 * Allow null values
 * If the class doesn't include equals and hashcode means Set will allow duplicate.
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Movie> hashSet = new HashSet<>();
        hashSet.add(new Movie("Mersal", 2017, "Vijay", "Atlee"));
        hashSet.add(new Movie("Bigil", 2019, "Vijay", "Atlee"));
        hashSet.add(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));
        hashSet.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        hashSet.add(null);
        // set will allow same value if there is no hashcode and equals method in the Book class
        hashSet.add(new Movie("Theri", 2016, "Vijay", "Atlee"));
        Movie movie = new Movie("Mersal", 2017, "Vijay", "Atlee");
        System.out.println(hashSet.contains(movie));
        System.out.println(hashSet); // it will not preserve the order
        hashSet.remove(movie); // remove the value
        hashSet.forEach(c -> System.out.println(c.toString()));
    }
}
