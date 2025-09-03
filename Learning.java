
import java8_features.stream.Movie;

import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


interface A {
    void check();

    default void defaultMethod() {

    }
}

interface B {
    void check();

    default void defaultMethod() {

    }
}

interface check {
    void method1(int a, String b);

    default void method3() {

    }
}
interface check1 {
    void method1(int a, String b);

    default void method3() {

    }
}

class Profile implements check , check1{




    @Override
    public void method1(int a, String b) {

    }

    @Override
    public void method3() {
        check1.super.method3();
    }

//    @Override
//    public void method3() {
//        check.super.method3();
//    }
}

public class Learning implements Comparator<Learning>, Comparable<Learning>, A, B {
    @Override
    public void check() {

    }
    @Override
    public void defaultMethod() {
        A.super.defaultMethod();
    }

    Learning() {
        System.out.println("Learning constructor");
    }


    public static void getmovie(Movie movie) {
        System.out.println(movie);
    }

    public long maxKelements(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums)
            pq.offer(x);
        long score = 0;
        while (!pq.isEmpty() && k > 0) {
            score += pq.peek();
            int x = (int) Math.ceil(pq.poll() / 3.0);
            pq.add(x);
            k--;
        }
        return score;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            if (pos < 0)
                pos = -(pos + 1);
            if (pos < sub.size()) {
                sub.set(pos, num);
            } else {
                sub.add(num);
            }
        }
        return sub.size();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, SQLException {
        Integer x = null;
        Integer y = 127;
        assert x != null : "The list should never be null here"; // Line 2
        System.out.println(x == y); // Line 1
        System.out.println(x); // Line 3

        String str1 = "abz";
        String str2 = "ad";
        int index = 0;
        for(char ch: str1.toCharArray()){
            int temp1 = ch - 97 ;
            int temp2 = str2.charAt(index);
            System.out.println(temp1%25);
        }
        if(str1.charAt(0) == '0'){

        }
      int n = str1.charAt(0)-97;
        int s = str1.charAt(0);
        System.out.println(n+" "+s);
    }


    @Override
    public int compareTo(Learning o) {
        return 0;
    }

    @Override
    public int compare(Learning o1, Learning o2) {
        return 0;
    }
}



//Exception in thread "main" java.lang.NullPointerException: Cannot assign field "a" because "pass" is null
//at Main.main(Learning.java:273)
class Main {
    public static String longest(int i, int j, String s) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
    public static void dothis(){
        System.out.println("Do this");
        throw new RuntimeException();
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> maxFreq = new HashMap<>();
        for (String word : words2) {
            // Temporary map to count frequency of characters in the current word
            Map<Character, Integer> tempMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                tempMap.merge(ch, 1, Integer::sum);
            }
            // Update the global map with the maximum frequency of each character
            for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
                char ch = entry.getKey();
                int freq = entry.getValue();
                maxFreq.put(ch, Math.max(maxFreq.getOrDefault(ch, 0), freq));
            }
        }
//
//        for(String word: words1){
//            Map<String, Integer> temp = new HashMap<>();
//            for(char ch: word.toCharArray()){
//                temp.merge(String.valueOf(ch),1,Integer::sum);
//            }
//            int count =0;
//            for(Map.Entry<String , Integer> val : map.entrySet()){
//                if(temp.get(val.getKey()) >=val.getValue())
//                    count++;
//                else
//                    break;
//            }
//            if(count == map.size()){
//                list.add(word);
//            }
//        }
        return list;

    }

    public static void main(String[] args) {



        try{
            System.out.println("Main method");
            dothis();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println("Finally method");
        }
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread 2: Sleeping...");
                Thread.sleep(5000);
                System.out.println("Thread 2: Finished.");
            } catch (InterruptedException e) {
                System.out.println("Thread 2: Interrupted!");
            }
        });
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Main: Interrupting Thread 2...");
                thread2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        String digits = "3392";
        System.out.println(digits.charAt(2) - '0');
        System.out.println(digits.charAt(2));
        int num = digits.charAt(2) ;
        System.out.println(num);
        Queue<Integer> pq = new PriorityQueue<>();

        char c = '9' - '5';
        System.out.println(c);

        String s = "abcde";
        System.out.println(s.substring(1, 3));
        // Immutable list
        List<String> immutableList = Stream.of("apple", "banana").toList();
//         immutableList.add("cherry"); // Throws UnsupportedOperationException

        // Modifiable list
        List<String> modifiableList = Stream.of("apple", "banana").collect(Collectors.toList());
        modifiableList.add("cherry"); // Works without exception

        System.out.println(modifiableList instanceof ArrayList);
        System.out.println("Immutable List: " + immutableList);
        System.out.println("Modifiable List: " + modifiableList);
        char[][] charr = new char[4][4];
        if (charr[1][1] == '\u0000') {
            System.out.println("The character at charr[1][1] is the default null character.");
        } else {
            System.out.println("The character at charr[1][1] has been set to something else.");
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();


    }
}
class Person extends RecursiveTask<Integer> {
    int count;
    int val;
    int sum = 0;

    Person(int val, int count, int sum) {
        this.val = val;
        this.count = count;
        this.sum = sum;
    }

    @Override
    protected Integer compute() {
        if (count == 10) {
            return sum;
        }
        sum = val++;
        count= count+1;
        Person person = new Person(val, count, sum);
        person.fork();
        Person person1 = new Person(val, count, sum);
        person1.fork();
        System.out.println("Sum: "+sum + "Count: "+count);
        return person.join() + person1.join();
    }
}

class MyChildren{
    int a;
//    MyChildren(int a){
//        this.a = a;
//    }

}
class MyGeneric extends MyChildren{
   int b;
    public MyGeneric(int a, int b){
        super.a = a;
        this.b = b;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyGeneric myGeneric = new MyGeneric(3,4);
        System.out.println(myGeneric.a + myGeneric.b);
    }
}

