package java8_features.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamClass {

    public static boolean isPrime(int value){
        if(value%2 ==0 ){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        String val = "dklkekdhdlkg";

        // find out first non repeating character from the string

        Character result = val.chars().mapToObj(e-> (char) e).collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(e-> e.getValue() == 1).findFirst().map(e -> e.getKey()).orElse(null);
        System.out.println("First non repeating character: "+result);

        List<String> words = Arrays.asList("apple", "banana", "ape", "bat", "ball", "cat", "dog", "ant", "axe");

        for(String word: words){
            System.out.println(word);
        }

//        Given a list of words, group them by their first character. However, within each group,
//        the words should be sorted by their length in descending order, and if two words have the same length,
//        they should be sorted alphabetically in ascending order.

        HashMap<Character, List<String>> wordsGrouped = words.stream()
                .collect(Collectors.groupingBy(e -> ((String) e).charAt(0), HashMap<Character, List<String>>::new, Collectors.toList()));

        Comparator<String> customComperator = Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());

        Map<Character, List<String>> wordsMap =  wordsGrouped.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream().sorted(customComperator).toList()
        ));

        for (Map.Entry<Character, List<String>> word: wordsMap.entrySet()){
            System.out.println(word.getKey()+" : "+word.getValue());
        }

//        You have a list of integers. Partition them into two groups: prime numbers and non-prime numbers. However, you must do this in a single stream operation and return a Map<Boolean, List<Integer>> where true maps to primes and false maps to non-primes.
//
//                Challenge: The isPrime check can be computationally expensive. Can you implement it in a way that avoids checking the same number for primeness multiple times? (Hint: Think about using a helper method, but the stream operation itself should be a single statement).
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 17, 19, 23, 29);
        HashMap<Boolean, List<Integer>> primeAndNonPrime = numbers.stream().collect(Collectors.groupingBy(e-> isPrime(e), HashMap<Boolean, List<Integer>>::new,Collectors.toList() ));
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

        // Task: Sort using stream api based on year
        List<Movie> moviesSorted = moviesList.stream().sorted((o1, o2) -> o1.getYear() - o2.getYear()).toList();
        System.out.println(moviesSorted);

        Stream<Movie> stream1 = moviesList.stream().filter(m -> m.getYear() >2017).limit(3);
        Stream<Movie> stream2 = stream1.sorted();
        IntStream stream3 = stream2.mapToInt(e -> e.getYear());
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


        // find the longest common prefix among all strings in the list

        List<String> list = new ArrayList<>(Arrays.asList("flood","flower","floor"));
        // 1st approach using intstream
        int minLength = list.stream().min(Comparator.comparingInt(String::length)).get().length();
        int prefixLength = IntStream.range(0, minLength).takeWhile( e ->  list.stream().map(s-> s.charAt(e)).distinct().count() == 1).max().getAsInt();
        String commonPrefix = prefixLength >= 0 ?
                list.getFirst().substring(0, prefixLength + 1) :
                "";
        System.out.println("Common prefix: '" + commonPrefix + "'");
        // 2nd approach using reduce
        String commonPrefix1 = list.stream().reduce((s1, s2)->{
            int min = Math.min(s1.length(), s2.length());
            int i=0;
            while(i<min && s1.charAt(i) == s2.charAt(i)){
                i++;
            }
            return s1.substring(0, i);
        }).get();
        System.out.println("Common prefix: '" + commonPrefix1 + "'");
    }
}
