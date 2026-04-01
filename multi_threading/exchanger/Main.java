package multi_threading.exchanger;

import java.util.concurrent.Exchanger;
public class Main{
    public static void main(String[] args) {
        Exchanger<Integer> e = new Exchanger<>();
        Thread t = new Thread(new A(10, e));
        Thread t2 = new Thread(new B(20, e));
        t.start();
        t2.start();
    }
}
class A implements Runnable{
    Integer i;
    Exchanger<Integer> e;
    A(Integer i, Exchanger<Integer> e){
        this.e = e;
        this.i = i;
    }
    public void run(){
        System.out.println("Thread A, before exchange: " + i);
        try {
            Integer x = e.exchange(i);
            System.out.println("Thread A, after exchange: " + x);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
class B implements Runnable{
    Integer i;
    Exchanger<Integer> e;
    B(Integer i, Exchanger<Integer> e){
        this.e = e;
        this.i = i;
    }
    public void run(){
        System.out.println("Thread B, before exchange: " + i);
        try {
            Thread.sleep(5000);
            Integer x = e.exchange(i);

            System.out.println("Thread B, after exchange: " + x);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }


}