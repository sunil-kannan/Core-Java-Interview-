package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIterator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        // listIterator has an add method , which allows you to add values while iterating
        java.util.ListIterator<Integer> listIt = list.listIterator();
        while(it.hasNext()){
            Integer value = it.next();
            System.out.println(value);
            if(value.equals(3)){
                it.remove();
            }
        }
    }
}
