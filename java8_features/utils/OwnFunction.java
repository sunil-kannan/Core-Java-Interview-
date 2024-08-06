package java8_features.utils;

import java.util.Objects;

@FunctionalInterface
interface CustomFunction<T, R>{
    R apply(T t);

//    CustomFunction<Integer, Integer> f1 = x -> x*x;
//    CustomFunction<Integer, Integer> f2 = x -> x*2;
    default <S> CustomFunction<T, S> andThen(CustomFunction<? super R, ? extends S> after){
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    default <S> CustomFunction<S, R> compose(CustomFunction<? super S, ? extends T> before){
        Objects.requireNonNull(before);
        return (S s) -> apply(before.apply(s));
    }

}
public class OwnFunction {
    public static void main(String[] args) {

        CustomFunction<Integer, String> f1 = x -> "y";
        CustomFunction<String, String> f2 = x -> x.concat("x");

        CustomFunction<Integer,String> f3 = f1.andThen(f2);
        System.out.println(f3.apply(3));

        CustomFunction<Integer, String> f4  = f2.compose(f1);
        System.out.println(f4.apply(4));

    }
}
