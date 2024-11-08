package java8_features.stream;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person {
    String name;
    Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

public class Utils {

    public static void main(String[] args) {


        List<Person> Persons = Arrays.asList(
                new Person("Alice", 50000),
                new Person("Bob", 65000),
                new Person("Charlie", 78000),
                new Person("Sarah", 45000)
        );

        // Allows you to perform an additional transformation on the result of another collector.
        int averageAge = Persons.stream()
                .mapToInt(Person::getAge)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingInt(Integer::intValue), // First collector to find the average salary
                        average -> (int) Math.round(average))); // Additional operation: rounding to the nearest integer
        System.out.println("Average Salary after roundup: " + averageAge);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 8, 6, 7, 4, 9,10) ;

        // takeWhile() consider or take the stream of elements until the condition is true
        List<Integer> takeWhileResult = numbers.stream()
                .takeWhile(num -> num < 6)
                .toList();
        System.out.println(takeWhileResult);

        // dropWhile() drops or reject the element from the stream of elements until the condition is true.
        List<Integer> dropWhileResult = numbers.stream()
                .dropWhile(num -> num <= 5)
                .toList();
        System.out.println(dropWhileResult);

        ArrayList<String> list = null;
        // Stream.ofNullable() helps to handle the null stream and NullPointerException.
        Stream<ArrayList<String> > value
                = Stream.ofNullable(list);
        System.out.println("Values of Stream:");
        value.forEach(System.out::println);


        Map<String, Integer> teeing = numbers.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (e1, e2) -> Map.of("max",e1.get(), "min", e2.get())
        ));
        System.out.println(teeing);

        // Convert IntStream to Stream<Integer>
        List<Integer> intStream1 = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intStream1);

        List<String> str = Arrays.asList("ciao", "happy", "bye", "happy", "ciao");
        Map<String, Integer> groupByStringAndGetCount = str.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        System.out.println(groupByStringAndGetCount);

        // 1. Given a list of integers, filter out the even numbers and then square the remaining odd numbers. Collect the results into a list.
        List<Integer> squareEvenNo = numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n).toList();
        System.out.println(squareEvenNo);

        // 2. Given a list of sentences, split each sentence into words and collect all unique words into a list.
        List<String> sentences = Arrays.asList("hello world", "world of streams", "hello streams");
        List<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct().toList();
        System.out.println("Unique words: " + uniqueWords);

        // 3. Given a list of strings, find the first string that starts with the letter "J" and is longer than 3 characters. If none is found, return "Not found".
        List<String> names = Arrays.asList("Tom", "Jerry", "John", "Jane", "Jim");
        String StringWithLetterJ = names.stream().filter(n -> n.charAt(0) == 'J' && n.length() > 3).findFirst().orElse("NOT FOUND");
        System.out.println(StringWithLetterJ);

        // 4. Given a list of integers, calculate the product of all numbers using reduce
        List<Integer> numbers1 = Arrays.asList(2, 3, 4, 5);
        Optional<Integer> sumOfInt = numbers1.stream().reduce((int1, int2) -> int1 * int2);
        System.out.println(sumOfInt.get());

        // 5. Given a list of words, partition them into two groups: those that contain the letter "a" and those that don't.
        List<String> words = Arrays.asList("apple", "banana", "grape", "orange", "kiwi");
        Map<Boolean, List<String>> partitioned = words.stream().collect(Collectors.partitioningBy(word -> word.contains("a")));
        System.out.println(partitioned);

        // 6. Implement a custom collector that collects all strings into a single string, separated by a comma.
        List<String> words1 = Arrays.asList("apple", "banana", "grape", "orange");
        String collector = words1.stream().collect(Collectors.joining(", "));
        String collector1 = String.join(", ", words1);
        System.out.println(collector);

        // 7. Given a list of sentences, count the occurrences of each word across all sentences.
        List<String> sentences1 = Arrays.asList("hello world", "hello everyone", "hello world");
        Map<String, Integer> occurrenceCount = sentences1.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        System.out.println(occurrenceCount);

        // 8. Given a list of people (with name and age), sort the list by age in ascending order. If two people have the same age, sort by name alphabetically.
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Alice", 22),
                new Person("Bob", 25)
        );
        List<Person> peopleList = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Comparator.comparing(Person::getName))).toList();
        peopleList.forEach(System.out::println);



    }
}
