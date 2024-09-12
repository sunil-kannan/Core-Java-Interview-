package collections.list.arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();//Creating array list
        list.add("Mango");//Adding object in array list
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        list.add(null);
        list.forEach(System.out::println);

    }
}
