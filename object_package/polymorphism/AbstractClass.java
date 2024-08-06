package object_package.polymorphism;


// An abstract class can not be final in Java
// You can not create instances of abstract class in Java
//
interface class1 {
    int interfaceMethod();

    default String defaultMethod() {
        return "Default method from interface";
    }
    static int staticMethod(){
        return 3;
    }
}

class class2 {
    public void Methods() {

    }

}

// abstract class can implements the interface and also extends the normal class
abstract class Parent extends class2 implements class1 {

    int id;
    String name;

    public Parent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void staticMethod() {
        System.out.println("Static method called from the parent class");
    }

    public void method1() {
        System.out.println("Called from parent class");
        super.Methods(); // like this you can call the parent class method from the abstract class
    }



    abstract String method2();


}

public class AbstractClass extends Parent {
    String company;

    public AbstractClass(int id, String name, String company) {
        super(id, name);
        this.company = company;
    }

    @Override
    public int interfaceMethod() { // this method if from the abstract parent class (interface) which is implemented
        return 0;
    }


    @Override
    String method2() {
        return "Java";
    }

    public void method1() {
        System.out.println("Called from child class" + "id: " + super.id + " name: " + super.name + " Company: " + company);
    }

    public static void staticMethod() {
        System.out.println("Static method called from the child class");
    }

    public static void main(String[] args) {
        Parent parent = new AbstractClass(3, "Sunil", "Amazon");
        parent.method1(); // this will call the child class
        parent.defaultMethod(); // this is a default method of interface
        parent.staticMethod(); // you can call the static method like this it will invoke the method from Parent class

    }

}
