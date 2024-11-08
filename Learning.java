
import java8_features.stream.Movie;

import java.sql.SQLException;
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
    default void method3(){

    }
}

class Profile implements check{

    @Override
    public void method1(int a, String b) {

    }
}

public class Learning  implements Comparator<Learning>, Comparable<Learning>, A, B {
    @Override
    public void check() {

    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);

            if (stack.isEmpty())
                return false;

            System.out.println("Came");
            char c = stack.pop();
            switch (ch) {
                case ')'->{
                    if (c != '(')
                        return false;
                }

                case '}'->{
                    if (c != '{')
                        return false;
                }
                case ']'->{
                    if (c != '[')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    @Override
    public void defaultMethod() {
        A.super.defaultMethod();
    }

    Learning() {
        System.out.println("Learning constructor");
    }


    private static final String TEXT = """
            It was many and many a year ago,
            In a kingdom by the sea,
            That a maiden there lived whom you may know
            By the name of ANNABEL LEE;
            And this maiden she lived with no other thought
            Than to love and be loved by me.
            I was a child and she was a child,
            In this kingdom by the sea;
            But we loved with a love that was more than love-
            I and my Annabel Lee;
            With a love that the winged seraphs of heaven
            Coveted her and me.""";

    public static int minLength(String s) {
        StringBuilder buffer = new StringBuilder(s);
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
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


    public static void main(String[] args) throws InterruptedException, ExecutionException, SQLException {
        System.out.println(isValid("(())"));
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

class Employee {
    private String name;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private Double salary;
}



class Resource {
    public synchronized static void methods(){
        System.out.println(Thread.currentThread().getName() + " has acquired the lock and is going to sleep.");

        try {
            // Thread goes to sleep while holding the lock
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " has finished sleeping and will now release the lock.");
    }
    public synchronized void accessResource() {
        System.out.println(Thread.currentThread().getName() + " has acquired the lock and is going to sleep.");

        try {
            // Thread goes to sleep while holding the lock
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " has finished sleeping and will now release the lock.");
    }
}

class Pass{
    Integer a;
    String b;
}
//Exception in thread "main" java.lang.NullPointerException: Cannot assign field "a" because "pass" is null
//at Main.main(Learning.java:273)
class Main {
    public static String longest(int i, int j, String s){

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    public static void check(Pass pass){
        Objects.requireNonNull(pass);
        pass.a = 4;
    }
    public static void main(String[] args) {

        AnyClass anyClass = new AnyClass();

        new Thread()
        {
            @Override
            public void run()
            {
                anyClass.anyMethod();
            }
        }.start();


        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p);

        System.out.println(Integer.compare(3,4));
        int n=38;

        LinkedList<Integer> linkedList = new LinkedList<>();
        Collections.sort(linkedList);
        Object[] obj = new Object[4];

        String ch = "dkdkd";
        System.out.println(ch.substring(2,5));
        System.out.println(  longest(2,3,"sassa"));

        Resource resource = new Resource();
        Resource resource1 = new Resource();

        // Thread 1 trying to access the synchronized method
        Thread thread1 = new Thread(() -> resource.accessResource(), "Thread-1");

        // Thread 2 trying to access the synchronized method
        Thread thread2 = new Thread(() -> resource.accessResource(), "Thread-2");

        // Thread 1 trying to access the synchronized method
        Thread thread3 = new Thread(() -> resource.methods(), "Thread-3");

        // Thread 2 trying to access the synchronized method
        Thread thread4 = new Thread(() -> resource1.methods(), "Thread-4");
        thread1.start();
        thread2.start();
        thread3.start();thread4.start();

    }
}
class AnyClass
{
    void anyMethod()
    {
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    // Constructors, getters, and setters

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Default constructor is necessary for JAXB
    public Person() {}
}



