package collections.generics;

import java.util.*;



public class WildCard {
    private static void print(ArrayList<? extends Number> num) {
        for (Number n : num)
            System.out.println(n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(10);
        l1.add(20);
        print(l1);

        ArrayList<String> l2 = new ArrayList<>();
        l2.add("Java");
        l2.add("Python");
//        print(l2); // this is not possible because String doesn't extend the Number class
    }
}
