package Pattern.behavioral.observer;


import java.util.HashMap;
import java.util.Map;

class EventManager{
    Map<String, Listener> list = new HashMap<>();
    public void addListener(String key, Listener listener){
        list.put(key, listener);
    }
    public void removeListener(String key){
        list.remove(key);
    }
    public void listen(String listen){
        list.forEach((k, v) -> v.listen(listen));
    }
}

interface Listener{
    void listen(String listen);
}
class LoggingListener implements Listener{
    @Override
    public void listen(String listen) {
        System.out.println("LoggingListener is listening to "+listen);
    }
}
class EmailAlertListener implements Listener{
    @Override
    public void listen(String listen) {
        System.out.println("EmailAlertListener is listening to "+listen);
    }
}

/**
 * Observer is a behavioral design pattern that allows some objects to notify other objects about changes in their state.
 */
public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.addListener("Logging",new LoggingListener());
        eventManager.addListener("Email", new EmailAlertListener());
        eventManager.listen("First message");
    }
}
