import string_package.StringClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;


interface Operation{
    public int doOperation(int a, int b);

}
class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
public class Learning {

    int a = 1;

    public static void check() {
        String s = "393893";
        char[] ch = s.toCharArray();
        int numRows = 4;
        String sol = "";
        int temp = numRows;
        // int[][] arr= new int[numRows][numRows];
        int length = s.length() / 2;
        String[] arr = new String[length];
        System.out.println(arr.length);
        int count = 0;
        while (count <= s.length()) {
            int tempcount = 0;
            for (int i = 0; i < numRows; i++) {
                if (arr[i] == null) {

                } else {
                    arr[i] = arr[i] + s.charAt(count);
                }

                System.out.println(arr.length);
                count++;
            }
        }
    }

    private int operate (int a, int b, Operation op){
        return op.doOperation(a,b);
    }
    private static int multiply(int a, int b){
        return a*b;
    }

    public static void throwSomeEx(int a) throws FileNotFoundException, MyException{
        if(a==2){
            throw new MyException("Error");
        }
        throw new FileNotFoundException();
    }


//    private static ThreadLocal<String> requestData = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Operation sum = (a, b) -> a+b;
        Operation div = (a, b) -> a/b;
        Operation sub = (a, b) -> a-b;

        Learning  learning = new Learning();
        System.out.println(learning.operate(4,8,sum));
        System.out.println(learning.operate(3,1, div));
        System.out.println(learning.operate(5,2, sub));
        System.out.println(learning.operate(4,5,Learning::multiply));

        try{
            throwSomeEx(2);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(()->{
            return new SimpleDateFormat("yyyy-MM-dd");
        });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // Simulate handling multiple requests
        for (int i = 0; i < 5; i++) {
            final int requestId = i;
            executorService.submit(() -> handleRequest("Request-" + requestId));
        }
        executorService.shutdown();
    }
    static String  data = new String();
    public static void handleRequest(String request) {
        // Set the request data for the current thread
//        requestData.set(request);


        // Simulate processing the request
        try {
            Double rando =Math.random();
            data = rando.toString();
            check1(rando);
            Thread.sleep((long) (rando * 1000)); // Simulate variable processing time

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve and print the request data for the current thread
        System.out.println(Thread.currentThread().getName() + " processed " + data);

        // Clear the ThreadLocal variable
//        requestData.remove();
    }
    public static void check1(double random){
        System.out.println(Thread.currentThread().getName() + " processed 1 = "+random );
    }

}

