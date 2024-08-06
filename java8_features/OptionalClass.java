package java8_features;

import java8_features.stream.Movie;

import java.util.List;
import java.util.Optional;

public class OptionalClass {
    static Movie findMovieByName(String name){
        Movie movie = null;
        return movie;
    }
    static Optional<Movie> findMovieByNameWithOptional(String name){
        /**
         * Primary reason to use Optional is to convey to the user that it might not return the value they are looking for.
         * It can help in writing a neat code without using too many null checks
         */
        Movie movie = null;
        return Optional.ofNullable(movie);
    }
    public static void main(String[] args) {
        Movie movie = findMovieByName("Jilla");
        Optional<Movie> optionalMovie = findMovieByNameWithOptional("Master");
        if(optionalMovie.isPresent()){
            System.out.println("Movie is present");
        }
        else{
            System.out.println("Movie is not present");
        }
        // incase if there is no value means it will assign default value
        Movie movie2 = optionalMovie.orElse(new Movie("Jilla",2010, "Vijay","Atlee"));
        // you can also easily get the movie name
        String movieName = optionalMovie.map(Movie::getName).orElse("Unknown");

    }
}
