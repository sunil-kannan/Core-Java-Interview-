package collections.list.vectorandstack;

import java.util.*;

/**
 * LIFO(Last in first out)
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Java");
        stack.add("Python");
        stack.add(".Net");
        stack.add("Php");
        stack.pop(); // it will remove last element
        String lastElement = stack.peek(); // it will get the last element
        stack.add(2,"Php"); // add by index
        stack.push("GO lang"); // it is same as add method
        stack.addElement("Ruby"); // it is same as add method
        String firsElement = stack.firstElement(); // it will get the first element
        System.out.println("First Element: "+ firsElement);
        stack.clear(); // it will empty the stack
        System.out.println(stack);
        System.out.println(lastElement);


    }
}
