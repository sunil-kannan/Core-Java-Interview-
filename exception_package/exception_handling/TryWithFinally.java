package exception_package.exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithFinally {
    public void handleError(){
        System.out.println("Try with finally method executed");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());;
        } finally {
            // Ensure the reader is closed even if an exception occurs
            if (reader != null) {
                try {
                    reader.close(); // Close the BufferedReader
                    System.out.println("Resources were closed through finally method");
                } catch (IOException e) {
                    // Handle any exception that occurs while closing the reader
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
