package object_package.polymorphism;

class User{
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
        Company newUser = new Company("Sunil", 22, "Thiran tech");
        newUser.display();

    }
}
