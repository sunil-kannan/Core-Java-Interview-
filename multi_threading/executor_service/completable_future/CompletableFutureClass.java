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
//                System.out.println("Get order async start");
                Thread.sleep(3000);
//                System.out.println("Get order async end");
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

    public Integer saveOrders() {
        System.out.println("Save order: " + price);
        return price;
    }

    public CompletableFuture<Integer> sendEmail(Integer integer) {
        return CompletableFuture.supplyAsync(() -> {
            try {
//                System.out.println("Send email start"+integer);
                Thread.sleep(3000);
//                System.out.println("Send email end");
                return integer;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    static class Email implements Runnable {
        @Override
        public void run() {
            System.out.println("Sending Email");
        }
    }

    private ExecutorService service = Executors.newFixedThreadPool(3);

    public Integer saveOrder() {
        System.out.println("Saving order...");
        // Simulate saving order
        return 1; // Return order ID
    }

    public CompletableFuture<Void> adjustStock(Integer orderId) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Adjusting stock for order ID: " + orderId);
            // Simulate stock adjustment
        }, service);
    }

    public CompletableFuture<Void> processPayment(Integer orderId) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Processing payment for order ID: " + orderId);
            // Simulate payment processing
        }, service);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureClass object = new CompletableFutureClass();

        CompletableFuture<Integer> orderFuture = CompletableFuture.supplyAsync(object::saveOrder);

        CompletableFuture<Void> adjustStockFuture = orderFuture.thenCompose(orderId ->
                CompletableFuture.runAsync(() -> object.adjustStock(orderId))
        );

        CompletableFuture<Void> processPaymentFuture = orderFuture.thenCompose(orderId ->
                CompletableFuture.runAsync(() -> object.processPayment(orderId))
        );

        CompletableFuture<Integer> combinedFuture = CompletableFuture.allOf(adjustStockFuture, processPaymentFuture)
                .thenCompose(v -> orderFuture)
                .thenCompose(object::sendEmail);

        // Handle the result or any exception
        combinedFuture.thenRun(() -> {
            System.out.println("Email sent successfully.");
        }).exceptionally(ex -> {
            System.err.println("Error: " + ex.getMessage());
            return null;
        });

    }
}
