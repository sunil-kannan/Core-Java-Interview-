package exception_package.exception_handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class Parent1 {
    void doThis() throws RuntimeException{
        // This will throw a runtime exception (unchecked exception)
        int i = 3 / 0; // This will cause an ArithmeticException, which is a runtime exception
        throw new RuntimeException(); // This does not need a 'throws' clause
        // Unchecked exceptions, like RuntimeException, are not required to be declared in a method's throws clause.
        // The Java compiler does not force the developer to handle these exceptions explicitly because they represent
        // programming errors that should be corrected.
    }

    void doThat() throws FileNotFoundException {
        // BufferedReader will throw FileNotFoundException, which is a checked exception
        BufferedReader reader = new BufferedReader(new FileReader("file"));
    }
}

public class ThrowVsThrows {

    public void handleError() {
        Parent1 parent = new Parent1();
        parent.doThis(); // This will throw a runtime exception but does not require a 'throws' clause
        try{
            parent.doThat(); // This should be handled like this or declared with 'throws'
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
