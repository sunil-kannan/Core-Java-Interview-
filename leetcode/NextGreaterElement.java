package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize the result array with -1 (no greater element)

        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(stack);
            // While stack is not empty and the top of the stack is less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top of the stack is the next greater element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        // Print the result array
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr1 = {6,4, 5, 2, 10, 8};
        findNextGreaterElements(arr1);
        String binary = Integer.toBinaryString(444);
        StringBuilder s = new StringBuilder();
        s.append(binary);

        String reverse = s.reverse().toString();
        System.out.println(reverse  );

    }
}
