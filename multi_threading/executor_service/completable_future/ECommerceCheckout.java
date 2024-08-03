package multi_threading.executor_service.completable_future;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ECommerceCheckout {

    // Fetch user details asynchronously
    public CompletableFuture<UserDetails> fetchUserDetailsAsync(UserDetails userDetails) {
        return CompletableFuture.supplyAsync(() -> {
                int n= 1/0;
                System.out.println("Fetch user details thread name: "+Thread.currentThread().getName());
            return userDetails;
        });
    }

    // Process order asynchronously
    public CompletableFuture<Order> processOrderAsync(UserDetails userDetails) {
        return CompletableFuture.supplyAsync(() -> {
            try {
//                int n =1/0;
                System.out.println("Process order thread name: "+Thread.currentThread().getName());
                Thread.sleep(2000); // Simulating a delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Simulate order processing
            return new Order(userDetails, 100.0);
        });
    }

    // Send confirmation email asynchronously
    public CompletableFuture<Void> sendConfirmationEmailAsync(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Send confirmation email thread name: "+Thread.currentThread().getName());
                Thread.sleep(500); // Simulating a delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // Update inventory asynchronously
    public CompletableFuture<Void> updateInventoryAsync(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Update inventory thread name: "+Thread.currentThread().getName());
                Thread.sleep(500); // Simulating a delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public static void doCheckout() throws ExecutionException, InterruptedException, RuntimeException {
        UserDetails userDetails = new UserDetails("John","123 Elm St.","Credit Card");
        ECommerceCheckout checkout = new ECommerceCheckout();

        CompletableFuture<UserDetails> userDetailsFuture = checkout.
                fetchUserDetailsAsync(userDetails)
                .exceptionally(ex ->{
                    System.err.println(ex.getMessage());
                    throw new RuntimeException();
                });

        CompletableFuture<Order> orderFuture = userDetailsFuture
                .thenCompose(checkout::processOrderAsync).exceptionally(ex ->{
                    System.err.println("Exception occured: "+ex.getMessage());
                    return null;
                });

        CompletableFuture<Void> emailFuture = orderFuture
                .thenCompose(checkout::sendConfirmationEmailAsync);

        CompletableFuture<Void> inventoryFuture = orderFuture
                .thenCompose(checkout::updateInventoryAsync);

        // Combine the two futures to wait for both email and inventory updates to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(emailFuture, inventoryFuture);

        // Wait for all tasks to complete
        allOf.get();

        System.out.println("Checkout process completed successfully.");
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        doCheckout();
    }

    // Example classes
    static class UserDetails {
        String name;
        String address;
        String paymentMethod;

        UserDetails(String name, String address, String paymentMethod) {
            this.name = name;
            this.address = address;
            this.paymentMethod = paymentMethod;
        }

        @Override
        public String toString() {
            return "UserDetails{name='" + name + "', address='" + address + "', paymentMethod='" + paymentMethod + "'}";
        }
    }

    static class Order {
        UserDetails userDetails;
        double totalPrice;

        Order(UserDetails userDetails, double totalPrice) {
            this.userDetails = userDetails;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{userDetails=" + userDetails + ", totalPrice=" + totalPrice + '}';
        }
    }
}
