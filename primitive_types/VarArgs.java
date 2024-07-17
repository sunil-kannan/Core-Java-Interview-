package primitive_types;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(3,4,5,6,40,292,89);
        fun(2,3,"java", "python");
        // int ...v and String ...v are examples of variable arguments (varargs).
        // They allow a method to accept zero or more arguments of a specified type.

        // fun(); // Ambiguous method call. If there are two vararg functions with the same name, it will lead to ambiguity. If there is only one method with the same name, there is no need to give parameters compulsorily.
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
    static void fun(String ...v){
        System.out.println(Arrays.toString(v));
    }
    static void fun(int a, int b, String ...v){
        System.out.println(a + b);
        System.out.println(Arrays.toString(v));
    }
}
