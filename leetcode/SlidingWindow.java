package leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Find sub array of size 'K' with maximum sum
 */
public class SlidingWindow {
    public static int maxSumOfSubArray(int[] arr, int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        int windowSum = Arrays.stream(arr, 0, k).sum();
        int maxSum = windowSum;
        for(int i=0; i<k; i++){
            windowSum = windowSum - arr[i] + arr[i+k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 5, 9, 6, 2};
        int k = 3;
        System.out.println("Sum: "+maxSumOfSubArray(arr, k));
    }
}
