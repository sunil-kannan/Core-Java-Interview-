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

        Map<Integer, Movie> movies1 = new LinkedHashMap<>();
        movies1.put(null, new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies1.put(2, new Movie("Bigil", 2019, "Vijay", "Atlee"));
        System.out.println(movies1);

        Map<Integer, Integer> map = new HashMap<>();
//        Set<Integer> set = map.entrySet();

//        List<Map.Entry<Integer, Integer>> list =
//                new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
//        for (Map.Entry<Integer,Integer> ma : list){
//
//        }
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if (o1.getValue() > o2.getValue()) return 1;
//                else if (o1.getValue().equals(o2.getValue())) {
//                    if (o1.getKey() < o2.getKey()) return 1;
//                    else return -1;
//
//                } else return -1;
//            }
//        });


        /**
         * EntrySet provides a set of all the key-value pairs (entries) in a map, making it easy to iterate through both keys and values simultaneously.
         * EntrySet can be used with Java Stream API for various operations, such as filtering, mapping, and collecting.
         * EntrySet can be used to sort a map based on custom criteria using a comparator.
         */

        List<Map.Entry<Integer, Movie>> list = new ArrayList<>(movies.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().getYear() - o2.getValue().getYear()); // sorting the integer
        Collections.sort(list, Comparator.comparingInt(o -> o.getValue().getYear()));
        list.forEach(sorted -> System.out.println(sorted.getKey() + " " + sorted.getValue()));

        list.sort(new Comparator<Map.Entry<Integer, Movie>>() {
            @Override
            public int compare(Map.Entry<Integer, Movie> o1, Map.Entry<Integer, Movie> o2) {
                if (o1.getValue().getYear() < o2.getValue().getYear()) {
                    return 1;
                } else if (o1.getValue().getYear() > o2.getValue().getYear()) {
                    return -1;
                } else {
                    return o1.getValue().getName().compareTo(o2.getValue().getName());
                }
            }
        });

        list.sort((o1, o2) -> o1.getValue().getName().compareTo(o2.getValue().getName())); // sorting the string
        list.forEach(sorted -> System.out.println(sorted.getKey() + " " + sorted.getValue()));

        // using EntrySet you can change the value without having concurrent modification exception
        for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
            if (entry.getValue().getYear() < 2017) {
                Thread.sleep(200);
                entry.setValue(new Movie("Sarkar", 2014, "Vijay", "A.R. Murugadoss")); // Adding an entry will cause an exception
            }
        }


    }
}
