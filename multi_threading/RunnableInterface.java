package multi_threading;

import java.io.FileNotFoundException;

public interface RunnableInterface {

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            int i = 45/0;
            System.out.println("Thread Starts in first way");
        }
    }


    public static void main(String[] args) {
        /* There are 3 ways you can run the thread using runnable interface*/

        // first way
        Thread thread = new Thread(new MyRunnable()); // you want to pass the object inside the parameter
        thread.start();
        System.out.println("It will print first");

        // second way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Starts in second way");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        //third way using lambda expression because runnable is a functional interface
        Runnable runnable1 = () -> {
            System.out.println("Thread Starts in third way");
        };
        Thread thread2 = new Thread(runnable1);
        thread2.start();

        System.out.println("Finish");
    }
}
