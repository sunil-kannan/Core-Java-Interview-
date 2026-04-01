package sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {

        //  O(n²)
        Sort bubbleSort = new BubbleSort();
        Sort selectionSort = new SelectionSort();
        Sort insertionSort = new InsertionSort();

        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int[] bubbleArr = arr.clone();
        bubbleSort.sort(bubbleArr);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleArr));

        int[] selectionArr = arr.clone();
        selectionSort.sort(selectionArr);
        System.out.println("Selection Sort: " + Arrays.toString(selectionArr));

        int[] insertionArr = arr.clone();
        insertionSort.sort(insertionArr);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArr));


    }
}
