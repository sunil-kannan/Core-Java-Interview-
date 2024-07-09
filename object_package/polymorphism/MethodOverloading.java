package object_package.polymorphism;

public class MethodOverloading {

    public static int multiply(int x, int y){
        return x*y;
    }
    public static double multiply(double i, double j){
        return i*j;
    }
    public static double multiply(int a, double b){
        return a*b;
    }
    public static double multiply(double c, int d){
        return c*d;
    }


    public static void main(String arg[]){
        System.out.println("Multiplication: "+MethodOverloading.multiply(3,3.5));
        System.out.println("Multiplication: "+MethodOverloading.multiply(4.5,3.5));
        System.out.println("Multiplication: "+MethodOverloading.multiply(3.5,5));
        System.out.println("Multiplication: "+MethodOverloading.multiply(3,6));
    }
}
