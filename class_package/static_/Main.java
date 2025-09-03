package class_package.static_;

public class Main {
    static class Class1{

    }
    class Class2{

    }

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Main.Class1 class11 = new Main.Class1();

        Main  main= new Main();
        Class2 class2 = main.new Class2();
    }
}
class Java{
    Main.Class1 class1 = new Main.Class1();

    Main main = new Main();
    Main.Class2 class2 = main.new Class2();
}
