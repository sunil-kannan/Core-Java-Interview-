package java8_features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CustomStream<T> {
    private final Stream<T> stream;

    public CustomStream(Stream<T> stream) {
        this.stream = stream;
    }

    // Custom filter operation
    public CustomStream<T> customFilter(Predicate<T> predicate) {
        return new CustomStream<>(stream.filter(predicate));
    }

    // Custom map operation
    public <R> CustomStream<R> customMap(Function<T, R> mapper) {
        return new CustomStream<>(stream.map(mapper));
    }

    // Collect the result
    public void forEach(java.util.function.Consumer<? super T> action) {
        stream.forEach(action);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 5, -10, 20);
        CustomStream<Integer> customStream = new CustomStream<>(list.stream());
        customStream.customFilter((n) -> n>3).customMap((map) -> map*map).forEach(System.out::println);
    }
}
