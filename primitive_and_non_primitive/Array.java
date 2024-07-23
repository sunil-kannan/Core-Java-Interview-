package primitive_and_non_primitive;

import java.util.Arrays;

public class Array {

    public static void twoDimensionalArray(){
        int[][] arr = new int[5][];
        for (int i=0; i<5; i++){
            arr[i]= new int[i];
            for(int j=0; j<i; j++){
               arr[i][j]=j;
            }
        }
        for(int[] list : arr){
            System.out.println(Arrays.toString(list));
        }

    }

    public static void main(String[] args) {
        twoDimensionalArray();
    }
}
