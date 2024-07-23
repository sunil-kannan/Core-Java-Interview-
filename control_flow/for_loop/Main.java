package control_flow.for_loop;

import java.util.Arrays;

public class Main {
    public static void infiniteForLoop(){
        for (;;){
            System.out.println("Infinite for loop");
        }
    }


    public static void forLoopWithBreak(){
        aa:
        for(int i=1;i<=3;i++){
            bb:
            for(int j=1;j<=3;j++){
                if(i==2&&j==2){
                    break bb;
                }
                if (i == 3 && j == 3) {
                    break aa;
                }
                System.out.println(i+" "+j);
            }
        }
    }
    public static void enhancedForLoop(){
        int[] arr = {1,2,3,4,56};
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void forLoopInStream(){
        int[] arr = {1,2,3,4,56};
        Arrays.stream(arr).forEach(element ->{
            System.out.println(element);
        });

        // either this in simplest form
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {

        forLoopWithBreak();
        enhancedForLoop();
        forLoopInStream();
//        infiniteForLoop();





    }
}
