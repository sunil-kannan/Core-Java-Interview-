package object_package.polymorphism;

interface Demo1 {
    int interfaceMethod();
    default String defaultMethod() { // Although the name is "default", it is a public method
        return "Default method from interface Demo1";
    }
    static int staticMethod() {
        return 3;
    }
}
interface Demo2{
    default String defaultMethod(){
        return "Default method from interface Demo2";
    }
}

public class InterfaceDemo implements Demo1 , Demo2{
    @Override
    public int interfaceMethod() {
        return 0;
    }

    // The code below will give you an error because you can't reduce the visibility of the public method to default method
//    String defaultMethod() {
//        return "Default method from interface";
//    }

    // you need to override this method because 2 interface has this method, so it leads to ambiguity
    public String defaultMethod() { // You can override it like this, but it needs to be public
        return Demo1.super.defaultMethod(); // like this you can assign which interface to call
    }

    String defaultMethod1() {
        return "Default method";
    }

    public static void main(String[] args) {
        InterfaceDemo demo = new InterfaceDemo();
        System.out.println(demo.defaultMethod()); // Calls the overridden default method of the subclass
        System.out.println(demo.defaultMethod1()); // Calls the method of the subclass
        System.out.println(demo.interfaceMethod()); // Calls the overridden method of the interface
        System.out.println(Demo1.staticMethod()); // You can call the static method like this
    }
}
