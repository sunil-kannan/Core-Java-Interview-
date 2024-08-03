package multi_threading.executor_service.completable_future;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsync {

    public static List<Employee> getEmployees(){
        List<Employee> listofEmployees= new ArrayList<>();
        listofEmployees.add(new Employee(1,"John"));
        listofEmployees.add(new Employee(2, "Gopal"));
        listofEmployees.add(new Employee(3, "Karthik"));
        return listofEmployees;
    }
    public static List<Employee> supplyAsync() throws ExecutionException, InterruptedException {
        // the task is submitted to a common ForkJoinPool
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(SupplyAsync::getEmployees);
        return completableFuture.get();
    }
    public static List<Employee> supplyAsyncWithExecutorService() throws ExecutionException, InterruptedException {
        // ExecutorService will control the thread pool for executing the task.
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture
                .supplyAsync(SupplyAsync::getEmployees, executorService);
        return completableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Employee> employeeList = supplyAsync();
        List<Employee> employeeList1 = supplyAsyncWithExecutorService();
       employeeList.forEach(System.out::println);
    }
}
