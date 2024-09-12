package collections.concurrency;

import java8_features.stream.Movie;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, Movie> movies = new ConcurrentHashMap<>();
        movies.put(1, new Movie("Mersal", 2017, "Vijay", "Atlee"));
        movies.put(2, new Movie("Bigil", 2019, "Vijay", "Atlee"));
        movies.put(4, new Movie("Theri", 2016, "Vijay", "Atlee"));
        movies.put(3, new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                movies.forEach((integer, movie) -> {
                    try {
                        Thread.sleep(280);
                        System.out.println("Key: "+integer+"Movie actor: "+movie.getActor());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                movies.forEach((integer, movie) -> {
                    try {
                        Thread.sleep(200);
                        if(integer == 3){
                            // changing specific field will not throw concurrent modification exception
                            movie.setActor("John");
                            // changing whole object will throw concurrent modification exception in case you are not using concurrent.
                            movies.put(4, new Movie("Rolex", 2025, "Suriya", "Lokesh"));
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        };

        /**
         * Both threads are running simultaneously.
         * Thread 1 = only iterate the hashmap
         * Thread 2 = changes the hashmap while the thread 1 is iterating.
         * Concurrent hashmap allows both thread in the case of thread 1 is iterating and thread 2 is changing the value
         */

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        thread.start();

    }
}
