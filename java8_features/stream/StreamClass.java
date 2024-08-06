package java8_features.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;


public class StreamClass {

    public static void main(String[] args) {
        List<Movie> moviesList = Arrays.asList(
                new Movie("Mersal", 2017, "Vijay", "Atlee"),
                new Movie("Bigil", 2019, "Vijay", "Atlee"),
                new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"),
                new Movie("Theri", 2016, "Vijay", "Atlee"),
                new Movie("Rajapattai", 2011, "Vikram", "Suseenthiran"),
                new Movie("Dhruva Natchathiram", 2024, "Vikram", "Gautham Vasudev Menon"),
                new Movie("Kaththi", 2014, "Vijay", "A.R. Murugadoss"),
                new Movie("Soorarai Pottru", 2020, "Suriya", "Sudha Kongara"),
                new Movie("Jai Bhim", 2021, "Suriya", "Gnanavel"),
                new Movie("Singam", 2010, "Suriya", "Hari"),
                new Movie("Singam II", 2013, "Suriya", "Hari"),
                new Movie("Master", 2021, "Vijay", "Lokesh Kanagaraj"),
                new Movie("Kaithi", 2019, "Karthi", "Lokesh Kanagaraj"),
                new Movie("Petta", 2019, "Rajinikanth", "Karthik Subbaraj"),
                new Movie("Darbar", 2020, "Rajinikanth", "A.R. Murugadoss"),
                new Movie("Karnan", 2021, "Dhanush", "Mari Selvaraj"),
                new Movie("Asuran", 2019, "Dhanush", "Vetrimaaran")
        );

        // Task: Count how many movies each director has in the list.
        Map<String, Long> moviesCountByDirector = moviesList.stream().
                collect(Collectors.groupingBy(
                        Movie::getDirector,
                        Collectors.counting()
                ));
        moviesCountByDirector.forEach((k, v) -> System.out.println("Director name is " + k + " and he directed " + v + " movies"));

        // Task: Find all movies that were released after the year 2018.
        System.out.println("--------- Movies after the year 2018 ---------");
        List<Movie> moviesAfter2018 = moviesList.stream().
                filter(x -> x.getYear() > 2018).toList();
        moviesAfter2018.forEach(System.out::println);

        // Task: Get a list of unique lead actors in the movies list.
        System.out.println("--------- Unique actor list ---------");
        Set<String> uniqueActor = moviesList.stream().map(Movie::getActor).collect(Collectors.toSet());
        System.out.println(uniqueActor);

        // Task: Find the movie with the most recent release year.
        System.out.println("--------- Most recent release ---------");
        Optional<Movie> mostRecentMovie = moviesList.stream()
                .max(Comparator.comparingInt(Movie::getYear));
        System.out.println(mostRecentMovie.toString());

        // Task: Calculate the average release year of movies directed by Atlee.
        System.out.println("--------- Average release year of movies directed by Atlee ---------");
        OptionalDouble averageYear = moviesList.stream()
                .filter(movie -> "Atlee".equals(movie.getDirector()))
                .mapToInt(Movie::getYear)
                .average();
        System.out.println("Average release year of movies directed by Atlee: " + (averageYear.isPresent() ? averageYear.getAsDouble() : "0 "));

        // movies directed by A.R. Murugadoss and starring Vijay
        String moviesDirectedByMurugadossWithActorVijay = moviesList.stream().
                filter(x -> x.getDirector().equals("A.R. Murugadoss") && x.getActor().equals("Vijay"))
                .map(Movie::getName).collect(Collectors.joining(", "));
        System.out.println("Movies directed by A.R. Murugadoss and starring Vijay: " + moviesDirectedByMurugadossWithActorVijay);

        // movies group by actors and showcasing only the movie names
        Map<String, List<String>> groupByActor = moviesList.stream().
                collect(Collectors.groupingBy(
                        Movie::getActor,
                        Collectors.mapping(Movie::getName, Collectors.toList())
                ));
        groupByActor.forEach((k, v) -> System.out.println("Actor: " + k + ", Movies: " + v));

        // separating the movie by using partitioning based on the year
        Map<Boolean, List<Movie>> MovieAfter2020 =	moviesList.stream().collect(Collectors.partitioningBy(m -> m.getYear() >2020));
        MovieAfter2020.forEach((k, v) -> {
            if(k) {
                System.out.println("Movies after 2020: "+ v);
            }
            else {
                System.out.println("Movies before 2020: "+ v);
            }
        });

    }
}
