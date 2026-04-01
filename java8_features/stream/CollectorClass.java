package java8_features.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorClass {

    public static void main(String[] args) {
//        customCollectorExample();
        customCollectorSecondLargestNumber();
    }

    public static void customCollectorExample() {

        Collector<CharSequence, StringBuilder, String> customCollector =
                Collector.of(
                        StringBuilder::new, // Supplier
                        StringBuilder::append, // Accumulator
                        StringBuilder::append, // Combiner
                        StringBuilder::toString // Finisher
                );

                Collectors.filtering(null, null);

    }

    static class Employee implements Comparable<Employee> {
        private String name;
        private double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "  " + salary;
        }

        @Override
        public int compareTo(Employee o) {
            double l = this.salary - o.getSalary();
            return (int) l;
        }
    }

    public static void customCollectorSecondLargestNumber() {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7);

        PriorityQueue<Integer> secondLargestNumber = numbers.stream().collect(() -> new PriorityQueue<Integer>(Integer::compareTo),
                (queue, number) -> {
                    queue.offer(number);
                    if (queue.size() > 2){
                        queue.poll();
                    }
                },
                (queue1, queue2) -> {

                });
        secondLargestNumber.forEach(System.out::println);
//        if (!secondLargestNumber.isEmpty()) {
//            System.out.println(secondLargestNumber.peek());
//        }

//          CTS Interview question
        List<Employee> employees = Arrays.asList(
                new Employee("raja", 50000),
                new Employee("ebi", 10000),
                new Employee("ezekiel", 100000),
                new Employee("nish", 70000.0),
                new Employee("rajan", 500000.0));

        List<Employee> sorted = employees.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        int limit = 3;
        PriorityQueue<Employee> largestEmployeeList = employees.stream().collect(() ->
                        new PriorityQueue<>(Comparator.comparing(Employee::getSalary)),
                (queue, number) -> {
                    queue.offer(number);
                    if (queue.size() > limit){
                        queue.poll();
                    }
                },
                AbstractQueue::addAll);
        System.out.println("priority "+largestEmployeeList.poll());
//        largestEmployeeList.stream().peek(System.out::println);


//        System.out.println(largestEmployeeList);
        while (!largestEmployeeList.isEmpty()) {
            System.out.println(largestEmployeeList.poll());
        }
//        Using reduce function

//        employees.stream().reduce(new PriorityQueue<Employee>(),
//                (queue, employee) -> {
//                    queue.
//                })

        System.out.println();

        Employee highestEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(highestEmployee);


        Collector<Employee, ?, List<Employee>> test = Collectors.toCollection(ArrayList::new);
        Supplier<?> supplier = test.supplier();

    }

}
