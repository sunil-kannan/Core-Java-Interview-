package java8_features.stream;
import java.util.*;


public class ParallelStream {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for(int i=0; i<30; i++){
            list1.add(i);
        }
        /*
        By default, parallelStream uses the common ForkJoinPool, which typically has a number of threads equal
        to the number of available processors (cores) on the machine.
         */
        list1.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );


        List<Integer> list = new ArrayList<>();
        /*
        When you use reduce without an identity value, it returns an Optional because there's no guarantee
        that the stream will have any elements. If the stream is empty, Optional.empty() is returned,
        whereas for non-empty streams, it returns an Optional containing the result.
         */
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 4, 3, 5);
        System.out.println(list.stream().reduce(Integer::sum));
        System.out.println(listOfNumbers.parallelStream().reduce(Integer::sum)); // may be 20
        System.out.println(listOfNumbers.stream().reduce(0, Integer::sum)); // 16
    }
}
