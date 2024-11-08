package Pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

class StrategyContext{
    SortingStrategy sortingStrategy;
    public StrategyContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }
    public void setSortingStrategy(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }
    void sort(int[] array){
        sortingStrategy.sort(array);
    }
}

interface SortingStrategy{
    void sort(int[] array);
}
class BubbleSortingStrategy implements SortingStrategy{

    @Override
    public void sort(int[] array) {

    }
}
class MergeSortingStrategy implements SortingStrategy{

    @Override
    public void sort(int[] array) {

    }
}

/**
 * A strategy pattern is a behavioral design pattern that allows the behavior of an object to be selected at runtime.
 * It is one of the Gang of Four (GoF) design patterns, which are widely used in object-oriented programming.
 */
public class Main {
    public static void main(String[] args) {
        int[]arr = {2,6,2,5,7};
        StrategyContext sorting = new StrategyContext(new MergeSortingStrategy());
        sorting.sort(arr); // merge sort
        sorting.setSortingStrategy(new BubbleSortingStrategy());
        sorting.sort(arr); // bubble sort

    }
}
