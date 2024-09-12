package collections.map;

import java8_features.stream.Movie;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TreeMapDemo {
    static class MyTask implements Runnable{

        @Override
        public void run() {

        }
    }
    public static void main(String[] args) {
        Map<Movie, Integer> treeMap = new TreeMap<>();
        // key should contain comparator class in case if it is generics type, and it will be sorted according to that
        treeMap.put(new Movie("Bigil", 2019, "Vijay", "Atlee"), 2);
        treeMap.put( new Movie("Mersal", 2017, "Vijay", "Atlee"), 4);
        treeMap.put(new Movie("Sarkar", 2018, "Vijay", "A.R. Murugadoss"), 3);
        treeMap.put(new Movie("Theri", 2016, "Vijay", "Atlee"),1);
        System.out.println(treeMap);

        MyTask task = new MyTask();
        Thread t1= new Thread(task);
        t1.start();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() ->{
//            task.stop();
        },10, TimeUnit.MINUTES);
    }
}
