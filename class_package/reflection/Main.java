package class_package.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    private final String name;
    public int age;
    public String department;
    Student(String name, int age, String department){
        this.name = name;
        this.age = age;
        this.department = department;
    }
    public String getName(){
        return name;
    }
    public void doThis(String var){
        System.out.println("Do this method called "+ var);
    }
    private void thisIsPrivateMethod(){
        System.out.println("This is private Method");
    }
    public static void doThat(){
        System.out.println("Static method called");
    }
}
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Student student = new Student("john doe",13,"Science");
        Field[] fields = student.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(student,"Jack");
            }
        }

        Method[] methods = student.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().equals("doThis")){
                method.invoke(student,"John doe");
            } else if (method.getName().equals("doThat")) {
                method.invoke(null); // you can just pass null value instead of passing object for static method
            } else if (method.getName().equals("thisIsPrivateMethod")) {
                try{
                    method.invoke(student); // invoking private method
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
        System.out.println(student.getName());

    }
}
