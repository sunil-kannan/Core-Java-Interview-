package object_package.polymorphism;

class User{
    int a = 10;
    String name;
    int age;
    User(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }

}
class Company extends User{
    int a = 5;
    String companyName;

    Company(String name, int age, String companyName) {
        super(name, age);
        this.companyName = companyName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Company name: "+companyName);
    }
}
public class MethodOverriding  {

    public static void main(String[] args) {
        User newUser = new Company("Sunil", 22, "Thiran tech");
        newUser.display();
        System.out.println("Does variable can be overriden through polymorphism: "+newUser.a); // variables can't be override in runtime only method can be override in runtime

    }
}
