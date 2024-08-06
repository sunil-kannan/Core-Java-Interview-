package java8_features.method_reference;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


interface Consumer1<T> {
    Iterator<T> iterator();
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next()); // Process the item
        }
    }
}

class ListConsumer1<T> implements Consumer1<T> {
    private final List<T> list;
    public ListConsumer1(List<T> list) {
        this.list = list;
    }

    // Implementation of the iterator() method, returning the list's iterator
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

@FunctionalInterface
interface Employee{
    void getEmployeeName(String s);
}

class EmployeeImpl{
    public void employeeNameWithNonStaticMethod(String s){
        System.out.println("Employee name: "+s);
    }
    public static void employeeName(String s){
        System.out.println("Employee name: "+s);
    }
}

public class Main {

    public static void main(String[] args) {

        // Using a lambda expression to implement the Employee interface
        Employee employee = (String s) -> {
            System.out.println(s);
        };
        employee.getEmployeeName("John");
        EmployeeImpl emp = new EmployeeImpl() ;
        // Using a method reference to implement the Employee interface
        Employee employee1 = EmployeeImpl::employeeName;// method reference
        Employee employee2= emp::employeeNameWithNonStaticMethod; // method reference for non static method will be done by creating object
        employee2.getEmployeeName("John");

        List<String> myList = List.of("Godson", "Sunil", "Gopal");
        ListConsumer1<String> listConsumer = new ListConsumer1<>(myList);
        listConsumer.forEach(System.out::println); // Output: Godson, Sunil, Gopal

        // Commented out to show the alternative default list forEach method
        // myList.forEach(System.out::println);
    }
}
