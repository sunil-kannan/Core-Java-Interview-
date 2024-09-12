package java8_features.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * map Function:
 * The map operation is used to apply a transformation to each element in a stream, resulting in a one-to-one mapping.
 * It produces a new stream where each input element is transformed into a corresponding output element.
 * flatMap Function:
 * The flatMap operation is used to transform each element in a stream into a stream of multiple elements.
 * The resulting streams are then flattened into a single stream, effectively merging all the streams into one.
 */
public class FlatMap {
    public static void main(String[] args) {
        // Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );

        // One-to-one mapping using map
        // Here, the map operation returns the same list without any transformation.
        // The stream of lists is printed, resulting in printing each sublist as a whole.
        listOfLists.stream()
                .map(x -> x)  // Identity mapping: returns the same inner list
                .forEach(System.out::println);  // Prints each list: [Geeks, For], [GeeksForGeeks, A computer portal], [Java, Programming]

        // Mapping each inner list to a stream of that list
        // This creates a stream of streams (Stream<Stream<String>>).
        listOfLists.stream()
                .map(Collection::stream)  // Converts each list into a stream, creating a stream of streams
                .forEach(innerStream -> innerStream.forEach(System.out::println));  // Prints each element of the inner streams individually

        // Using flatMap to flatten the streams
        // The flatMap operation flattens the stream of lists into a single stream of elements.
        listOfLists.stream()
                .flatMap(Collection::stream)  // Flattens the Stream<List<String>> to Stream<String>
                .forEach(System.out::println);  // Prints each string: Geeks, For, GeeksForGeeks, A computer portal, Java, Programming
        /**
         * So if array contains a list of array means, you can use flat map
         */
    }
}
