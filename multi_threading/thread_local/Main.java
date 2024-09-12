package multi_threading.thread_local;

import java.util.UUID;

/**
 * The Java ThreadLocal class enables you to create variables that can only be read and written by the same thread.
 * Thus, even if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable,
 * the two threads cannot see each other's ThreadLocal variables.
 * Thus, the Java ThreadLocal class provides a simple way to make code thread safe that would not otherwise be so.
 */
class SharedMapWithUserContext implements Runnable{
     final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public SharedMapWithUserContext(Integer id){
        this.userId= id;
    }
    private Integer userId;
    @Override
    public void run() {
        System.out.println("start");
        threadLocal.set(userId);
        System.out.println("End");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadLocal.get());
        threadLocal.remove();
    }
}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
        Thread.sleep(500);
    }
}
