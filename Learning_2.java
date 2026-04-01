import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Learning_2 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("sunil", "Marketing", 35000),
                new Employee("sunil", "IT", 50000),
                new Employee("sunil","Account",30000)
        );

        Comparator<Employee> salaryComparator = Comparator.comparingInt(Employee::getSalary).reversed();
        List<Employee> sortOnSalary = employees.stream().sorted(salaryComparator).toList();
        sortOnSalary.forEach(System.out::println);

        Double averageSalary = employees.stream().mapToInt(Employee::getSalary).average().orElse(0);


        employees.stream().collect(Collectors.groupingBy(e-> e , Collectors.counting()));
    }
}

class Employee{
    private String name;
    private int salary;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


}
