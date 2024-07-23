import string_package.StringClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Demo {
    void doThis()  {
        // ...
        int i = 3/0;
    }
    void dothat() throws  FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("file"));
    }


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


public class Learning extends Demo{
    int a=1;

    static void method1(){

            Demo demo = new Demo();
            demo.doThis();


    }

    public static void main(String[] args) {

    method1();



    }

}
