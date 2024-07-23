package control_flow.while_loop;
import java.util.*;


public class Main {

    public static void whileWithIteratorInterface(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String i = it.next();
            if(Objects.equals(i, "B")){
                System.out.println("Removed element: " + i);
                it.remove();
            }
        }

        while (it.hasPrevious()) {
            String i = it.previous();
            System.out.print(i+ " ");
        }

        System.out.println();

        while (it.hasNext()){
            System.out.print(list.get(it.nextIndex())+" ");
            it.next();
        }
    }

    public static void main(String[] args) {
        whileWithIteratorInterface();
    }
}
