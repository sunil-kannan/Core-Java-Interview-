package sorting;

public interface Sort {
    void sort(int[] arr);

    public default void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
