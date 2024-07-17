package exception_package.exception_handling;



import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

class Parent {
    void doThis() throws SQLException  {
        // ...
    }
    static void dothat() throws SQLException {
        throw new SQLException();
    }


//    static {
//        try{
//            System.out.println("In static block of class A");
//            System.out.println(1 / 0); // It will throw java.lang.ArithmeticException
//        }catch (Exception e){
////             throw new NullPointerException(); //this is not possible, but you can handle through try catch
//            System.err.println(e.getMessage());
//        }
//    }
}

public class Main extends Parent {


    @Override
    void doThis() throws SQLException {
        // Compilation error because IOException is of broader scope than FileNotFoundException
    }

    // Method to score based on file content, handling FileNotFoundException
    static int score(String file) {
        Scanner fileContents = null;
        try {
            fileContents = new Scanner(new File(file));
            return Integer.parseInt(fileContents.nextLine());
        } catch (FileNotFoundException fileNotFound) {
            // Handle exception by returning 0 and logging error
            System.out.println("Result file does not exist");
            return 0;
        } finally {
            if (fileContents != null) {
                try {
                    fileContents.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void handleExceptionInMainMethod() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
    }


    public static void main(String[] args) {
        try {
            System.out.println(2.0/0);
            System.out.println(1/0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Finally executed");
            System.out.println(1/0);
//            System.out.println(2.0/0);
        }

        TryWithResources tryWithResources = new TryWithResources();
        MultiCatchBlock multiCatchBlock = new MultiCatchBlock();
        TryWithFinally tryWithFinally = new TryWithFinally();

        tryWithResources.handleError("wrong file");

        multiCatchBlock.handleError();

        tryWithFinally.handleError();


        /*
           The below line calls the score method with the argument "Wrong path". Since this path does not exist,
           the score method catches the FileNotFoundException and prints "Result file does not exist" to the console.
           It then returns 0
         */
        System.out.println(score("Wrong path"));

        try {
            /*
            This is also known as exception propogation
            Exception propagation is a process where the compiler makes sure that the exception is handled
            if it is not handled where it occurs. If an exception is not caught where it occurred, then the exception goes down the call
            stack of the preceding method and if it is still not caught there, the exception propagates further down to the
            previous method. If the exception is not handled anywhere in between, the process continues until the exception
            reaches the bottom of the call stack. If the exception is still not handled in the last method, i.e, the main method,
            then the program gets terminated.
             */
            handleExceptionInMainMethod();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
