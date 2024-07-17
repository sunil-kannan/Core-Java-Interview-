package exception_package.exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TryWithResources {

    public void handleError(String file) {

        /*
        Introduced in Java 7
        Try-with-resources" statement is a feature introduced in Java 7 that simplifies the process of working with resources
        such as files, streams, or sockets. It automatically closes the resources when they are no longer needed,
        reducing the chances of resource leaks and making the code more concise and readable.
        */
        System.out.println("Try with resources method executed");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            // If you are using try with resources means there is no need of using finally block
            // because try will take care of closing the resources
        }
    }
}
