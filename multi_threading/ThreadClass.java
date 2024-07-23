package multi_threading;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ThreadClass {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("Thread running from class MyThread. Thread name: " + Thread.currentThread().getName()); // Thread-0
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void dothis() {
            try {
                Thread.sleep(3000);
                System.out.println("dothis method called from MyThread Class. Thread name: " + Thread.currentThread().getName()); // main
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread running from class MyThread. Thread name: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getThreadGroup().getParent().getName()); // system
        System.out.println(myThread.getThreadGroup().getName()); // main

        // myThread.run();
        // By calling run method, it will not create you the new thread, you need to call start() it will create the thread and call the run method
        myThread.start();// this will be executed asynchronously
        myThread.dothis();// this will be executed by main Thread

        System.out.println(Thread.currentThread().toString());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        System.out.println(myThread1.isAlive()); // true

        /* The Thread.join() method in Java is used to ensure that one thread waits for another thread
        to complete its execution before it continues. This is particularly useful when you want to make sure
        that a thread has finished its task before proceeding with subsequent operations.  */
        myThread1.join();
        System.out.println(myThread1.isAlive()); // false


        Thread thread= new Thread(() ->{
            System.out.println("You can have your own name for the thread you are creating");
        },"My Thread");
        System.out.println(thread.getName()); // My Thread
        thread.setName("Java Thread");  // like this also you can change the values

    }
}
