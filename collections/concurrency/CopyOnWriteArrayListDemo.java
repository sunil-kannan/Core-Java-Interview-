package collections.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * It is thread safe version of list and kept in concurrent package.
 * For every write operation separate clone copy is created and JVM will synchronize the clone and actual copy.
 * CopyOnWriteArrayList will throw UnsupportedOperationException when you remove the value by using iterator.remove
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        for (Integer value : list) {
//            System.out.println(value);
//            if (value.equals(3)) {
//                list.add(2, 34); // which will throw you the ConcurrentModificationException
//            }
//        }

        List<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        Iterator<Integer> it = list1.iterator();
        while(it.hasNext()){
            Integer value = it.next();
            System.out.println(value);
            if(value.equals(3)){
                it.remove();
            }
        }

    }
}
