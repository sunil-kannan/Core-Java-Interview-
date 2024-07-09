package string_package;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class StringClass{

     static int Check(){
        return 4;
    }

    public  Boolean Check(int number) {
        System.out.println("Check method from String class");
        return  number >1 && true;
    }

    public String method(){
        return "StringClass Method";
    }

    public static void main(String[] args){

        String s1 = new String("code");
        String s2 = "code";
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true

        char[] ch = new char[]{'s', 'u', 'n', 'i', 'l'};
        String s3 = new String(ch, 2, 2);//(value, offset, count)
        System.out.println(s3); // ni

        /* ---------------------------------------------------------------------------------------------------------------- */
        String s4 = "Java";                 // s4 references the string literal "Java" in the string pool.
        String s5 = new String("Java");     // s5 references a new String object in the heap with the value "Java".
        s5 = s4.intern();                   // s4.intern() returns the reference to the string literal "Java" in the string pool.

        /*
        Does this remove the s5 from heap memory ?
        No, the intern() method does not remove the original s5 from heap memory. Instead, it assigns s5 the reference
        to the interned string (the string literal in the string pool).
        The original String object created by new String("Java") is still in the heap,
        but it becomes eligible for garbage collection if there are no other references to it.
        */

        String s6 = s5.intern();
        System.out.println(s4 == s5); // true
        System.out.println(s4 == s6); // true

        /* ---------------------------------------------------------------------------------------------------------------- */

        // String is immutable
        String s7 = "Java";
        System.out.println(s7.hashCode()); // 2301506
        s7 = s7 + "Programming";
        System.out.println(s7.hashCode()); // 148622647
        // So, therefore if you change the value means, the memory will also be changed
        /* ---------------------------------------------------------------------------------------------------------------- */

    }


}
