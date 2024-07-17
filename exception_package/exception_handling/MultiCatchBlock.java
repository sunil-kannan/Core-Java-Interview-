package exception_package.exception_handling;

//introduced in Java 7
public class MultiCatchBlock {
    public void handleError() {
        System.out.println("Multi Catch Block method executed");
        try {
            // Code that may throw NullPointerException or ArithmeticException
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (NullPointerException | ArithmeticException e) {
            // Handle both NullPointerException and ArithmeticException
            System.err.println(e.getMessage());
        }
    }

}
