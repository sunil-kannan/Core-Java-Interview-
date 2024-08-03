package multi_threading.thread_local;

import javax.naming.Context;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
class Contexts {
    private String userName;

    public Contexts(String userName) {
        this.userName = userName;
    }
}
class SharedMapWithUserContext implements Runnable{
    public SharedMapWithUserContext(Integer id){
        this.userId= id;
    }
    public static Map<Integer, Contexts> userContextPerUserId = new ConcurrentHashMap<>();
    private Integer userId;
    @Override
    public void run() {
        String name= UUID.randomUUID().toString();
        userContextPerUserId.put(userId, new Contexts(name));
        System.out.println("thread context for given userId: "
                + userId + " is: " + userContextPerUserId.get(userId));
    }
}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
        Thread.sleep(1000);
        System.out.println(SharedMapWithUserContext.userContextPerUserId.size());
    }
}
