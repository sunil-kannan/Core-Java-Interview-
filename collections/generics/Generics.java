package collections.generics;

interface Book<S>{
    void getBookName(S value);
}
class Print<T> implements Book<T>{
    T obj1;
    Print(T obj){
        this.obj1 = obj;
    }
    public void print(){
        System.out.println("Generic Class: "+obj1);
    }

    @Override
    public void getBookName(T value) {
        System.out.println(value);
    }
}
public class Generics {

    public static <T> void doThis(T var){
        System.out.println("Generic Method: "+var);
    }
    public static void main(String[] args) {
        Print<String> stringObj = new Print<>("Java");
        stringObj.print();
        stringObj.getBookName("The God Delusion");
        Print<Integer> intObj = new Print<>(69);
        intObj.print();

        doThis("Java");
        doThis(34);
    }


}
