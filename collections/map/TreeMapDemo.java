package collections.map;

import java8_features.stream.Movie;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TreeMapDemo {

    public static void main(String[] args) {

        Map<Movie, Integer> treeMap = new TreeMap<>();
        // key should contain comparator class in case if it is generics type, and it will be sorted according to that
        treeMap.put(new Movie("Bigil", 2019, "Vijay", "Atlee"), 2);
        treeMap.put( new Movie("Mersal", 2017, "Vijay", "Atlee"), 4);
        treeMap.put(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"), 3);
        treeMap.put(new Movie("Theri", 2016, "Vijay", "Atlee"),1);
        System.out.println(treeMap);

        /*
        TreeMap allows null key if a defined comparator allows it:
        in case of natural ordering, accessing or putting with null key results in NullPointerException.
         */
//        Comparator<Movie> nullAllowingComparator = Comparator.nullsFirst(Comparator.naturalOrder());
//        Map<Movie, Integer> treeMap1 = new TreeMap<>(nullAllowingComparator);
//        treeMap1.put(new Movie("Bigil", 2019, "Vijay", "Atlee"), 2);
//        treeMap1.put( null, 4);
//        System.out.println(treeMap1);

        Comparator<Integer> checkc = Comparator.comparingInt((u)-> u);
        Map<Integer, String> check = new TreeMap<>(checkc);
        check.put(2, null);
        check.put(5, null);
        System.out.println(check);
    }
}
