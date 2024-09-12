import string_package.StringClass;
import successive_refinement.abstraction.ArgumentMarshaler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Money{

}


abstract class Employee {
    public abstract boolean isPayday();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}
class EmployeeRecord {
    public enum EmployeeType { COMMISSIONED, HOURLY, SALARIED }

    public EmployeeType type;
    // Other relevant fields, such as name, id, etc.

    public EmployeeRecord(EmployeeType type) {
        this.type = type;
    }
}

class CommissionedEmployee extends Employee {
    private EmployeeRecord record;

    public CommissionedEmployee(EmployeeRecord record) {
        this.record = record;
    }

    @Override
    public boolean isPayday() {
        // Implementation specific to CommissionedEmployee
        return false;
    }

    @Override
    public Money calculatePay() {
        // Implementation specific to CommissionedEmployee
        return null;
    }

    @Override
    public void deliverPay(Money pay) {
        // Implementation specific to CommissionedEmployee
    }
}

class HourlyEmployee extends Employee {
    private EmployeeRecord record;

    public HourlyEmployee(EmployeeRecord record) {
        this.record = record;
    }

    @Override
    public boolean isPayday() {
        // Implementation specific to HourlyEmployee
        return false;
    }

    @Override
    public Money calculatePay() {
        // Implementation specific to HourlyEmployee
        return null;
    }

    @Override
    public void deliverPay(Money pay) {
        // Implementation specific to HourlyEmployee
    }
}

class SalariedEmployee extends Employee {
    private EmployeeRecord record;

    public SalariedEmployee(EmployeeRecord record) {
        this.record = record;
    }

    @Override
    public boolean isPayday() {
        // Implementation specific to SalariedEmployee
        return false;
    }

    @Override
    public Money calculatePay() {
        // Implementation specific to SalariedEmployee
        return null;
    }

    @Override
    public void deliverPay(Money pay) {
        // Implementation specific to SalariedEmployee
    }
}

interface EmployeeFactory {
    Employee makeEmployee(EmployeeRecord r) throws Exception;
}


class EmployeeFactoryImpl implements EmployeeFactory {
    static{
        System.out.println("Static method from EmployeeFactoryImpl");
    }
    public Employee makeEmployee(EmployeeRecord r) throws  Exception {
        switch (r.type) {
            case COMMISSIONED:
                return new CommissionedEmployee(r);
            case HOURLY:
                return new HourlyEmployee(r);
            case SALARIED:
                return new SalariedEmployee(r);
            default:
                throw new Exception();
        }
    }
}

abstract class A {
    abstract void showA();


}
interface C{
    void showC();
}
abstract class B extends A implements C {
    abstract void show1();
}
class Check extends B{

    @Override
    void showA() {

    }

    @Override
    public void show1() {

    }

    @Override
    public void showC() {

    }
}




public class Learning extends EmployeeFactoryImpl{
    static{
        System.out.println("Static method from Learning");
    }
    Learning(){
        System.out.println("Learning constructor");
    }
    public class Payroll {
        static{
            System.out.println("Static method from Payroll");
        }
        private EmployeeFactory employeeFactory = new EmployeeFactoryImpl();
        public Money calculatePay(EmployeeRecord r) throws Exception {
            Employee e = employeeFactory.makeEmployee(r);
            return e.calculatePay();
        }
    }
static class check implements Callable<Runnable>{
    @Override
    public Runnable call() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        return runnable;
    }
}
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RandomGenerator.StreamableGenerator streamableRnd
                = RandomGenerator.StreamableGenerator.of("L128X1024MixRandom");
        List<int[]> listOfArrOfIntsSG
                = streamableRnd.rngs(5) // get 5 pseudo-random generators
                .map(r -> r.ints(10)) // generate 10 ints per generator
                .map(IntStream::toArray)
                .toList();
        System.out.println(listOfArrOfIntsSG);
        listOfArrOfIntsSG.forEach(System.out::println);

//        Learning learning = new Learning();
//        int[][] arr = new int[2][3];
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        Future<Runnable> future = service.submit(new check());
//        Runnable runnable = future.get();
//        runnable.run();
//        service.shutdown();
//        System.out.println("dkkd"+future.get().run());
    }

}

