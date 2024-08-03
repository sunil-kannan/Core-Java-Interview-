package multi_threading.executor_service.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureClass {
    public Integer price;
    public CompletableFuture<Integer> getOrderAsync() {
        // Create a CompletableFuture and run the Callable task asynchronously
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return 4;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    // Example method to perform payment, which takes an order ID and returns a payment ID
    public Integer performPayment() {
        // Simulate some payment processing
        System.out.println("Performing payment for order ID: " + price);
        return price * 10; // Return some payment ID or value
    }

    public Integer saveOrders(){
        System.out.println("Save order: "+price);
        return price;
    }
    public CompletableFuture<Integer> sendEmail(Integer integer) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return price;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    static class Email implements  Runnable{
        @Override
        public void run() {
            System.out.println("Sending Email");
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        future.get();
//        future.complete(2);
        CompletableFutureClass object = new CompletableFutureClass();
        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> orderFuture = object.getOrderAsync()
                .thenApplyAsync(object::sendEmail).get();

        // Handle the result or any exception
        orderFuture.thenAccept(order -> {
            System.out.println("Order ID: " + order);
        }).exceptionally(ex -> {
            System.err.println(ex.getMessage());
            return null;
        });

        // To keep the main thread alive until the async task is complete
//        try {
//            Integer value = orderFuture.get();
//            System.out.println(value);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
