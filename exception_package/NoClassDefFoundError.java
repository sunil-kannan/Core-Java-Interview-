package exception_package;

// This error occurs when java runtime system doesn't find a class definition, which is present at compile but missing at run time.
// Basically the class name from target folder or bin folder is renamed or deleted so it cannot be able to identify the .class file

/*
Error: Could not find or load main class Errors.NoClassDefFoundError
Caused by: java.lang.ClassNotFoundException: Errors.NoClassDefFoundError
 */


public class NoClassDefFoundError {
    public static void main(String[] args) {
        System.out.println("Check");

        String value = new String("code");
        String value1 = "code";
        System.out.println(value.equals(value1));
    }
}
