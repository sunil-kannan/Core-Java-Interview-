package object_package.polymorphism;

class Demo{

    public static int check(int a){
        System.out.println("Calling from Demo class");
        System.out.println("Static variable: "+a);
        return '1';
    }
    public static String staticMethod(){
        return "Static Method Called From Demo Class";
    }
    public String stringMethod(){
        return "String from Demo";
    }


}
class Demo3 extends Demo {
    public static int check(int a){
        System.out.println("Calling from Demo3 class");
        return a;
    }
    public String stringMethod(){
        return "String from Demo3";
    }

}
public class MethodOverhiding extends Demo{

/*
    Method hiding occurs when a subclass defines a static method with the same name and signature as a static method in the superclass.
    Static methods are not polymorphic and are resolved at compile-time based on the reference type, not the actual object type.
*/
    public static String staticMethod(){ // this is Method overhiding
        return "Static Method Called From MethodOverhiding Class";
    }

    public static String staticMethod(String a){ // this is method overloading
        return a;
    }

    public static void main(String[] args) {
        System.out.println(MethodOverhiding.staticMethod()); // Static Method Called From MethodOverhiding Class
        System.out.println(MethodOverhiding.staticMethod("Java")); // this is method overloading
        Demo demo = new Demo3();
        demo.check(3);
        System.out.println(demo.stringMethod());
    }
}
