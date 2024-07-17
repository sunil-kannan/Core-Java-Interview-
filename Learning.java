import string_package.StringClass;

import java.util.ArrayDeque;
import java.util.Deque;

class Demo {
    static int staticVariable; // Stored in the method area
    public static int check(int a){
        System.out.println("Calling from Demo class");
        System.out.println("Static variable: "+staticVariable);
        return '1';
    }
    public Demo() {}
    public  Boolean Check(int number) {

        return  number >1 && true;
    }

    public void PassReference(Learning learning){ learning.a =10;}

    private String value1;
}
class Demo3 extends Demo{
    public static int check(int a){
        System.out.println("Calling from Demo3 class");
        return a;
    }
}


interface  Demo2{
    static int Check() {
        return 0;
    }
    static int check2(){
        return 1;
    }
}


public class Learning{
    int a=1;
    public void check(){
        Demo demo = new Demo3();
        demo.Check(3);
        Learning object = new Learning();
        Learning object2 = object;
        object2.a=49;
        System.out.println(object.a);

        String check = "Sunil";
        String check1 = "Sunil";
        System.out.println("Compare: "+check1.compareTo(check));
        demo.PassReference(object);
        System.out.println("Object A: "+object.a);
        Demo.staticVariable = 30;
        System.out.println(demo.check(3));
    }
    public static void main(String[] args) {
    try{
        Learning object1 = new Learning();
        object1.check();


        Thread.sleep(5000);
        System.out.println("Static Variable: "+Demo.staticVariable);

    }catch (Exception e){
        e.printStackTrace();
    }
    finally {
        System.out.println("Finally method called");
    }

    }

}
