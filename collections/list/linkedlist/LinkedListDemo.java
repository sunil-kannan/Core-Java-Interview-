package collections.list.linkedlist;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
//        list.addfir

        Deque<Integer> list2 = new LinkedList<>();

        list2.addFirst(3);
        list2.addLast(4);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addFirst(3);
    }
}
