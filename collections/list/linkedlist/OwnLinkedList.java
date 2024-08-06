package collections.list.linkedlist;


import java.util.ArrayList;
import java.util.LinkedList;

public class OwnLinkedList<T> {
    private Node<T> head;
    private int size;

    static class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T d) {
            data = d;
            next = null;
        }
    }

    public int size() {
        return size;
    }

    public void insert(T data) {
        Node<T> new_node = new Node<>(data);
        if (this.head == null) {
            this.head = new_node;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        size++;
    }

    public void print(OwnLinkedList<T> list) {
        Node<T> currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public void removeFirstNode() {
        if (this.head == null) {
            // if list is already empty
            return;
        }
        if (this.head.next == null) {
            // if only one element is present in the list
            this.head = null;
            size--;
            return;
        }
        Node<T> current = this.head;
        head= current.next;
        current=null;
        size--;
    }

    public void removeLastNode() {
        if (this.head == null) {
            // if list is already empty
            return;
        }
        if (this.head.next == null) {
            // if only one element is present in the list
            this.head = null;
            size--;
            return;
        }
        Node<T> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }


    public static void main(String[] args) {
        OwnLinkedList<Integer> list = new OwnLinkedList<>();
        list.insert(1);
        list.insert(5);
        list.insert(9);
        list.insert(52);
        list.insert(549);
        list.insert(3);
        list.removeFirstNode(); // it will remove first node
        list.removeLastNode(); // it will remove last node
        list.removeFirstNode();
        list.print(list);
        System.out.println("Size: " + list.size());
    }
}
