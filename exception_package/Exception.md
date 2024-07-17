# Exception Handling in Java
## Overview
Exception handling in Java is a powerful mechanism to handle **runtime errors**, ensuring the normal flow of the application. 
It is managed via five keywords: try, catch, finally, throw, and throws.

## Exception Hierarchy
- Throwable: The superclass of all exceptions.
  - Exception: The class for exceptional conditions that programs should catch.
    - RuntimeException: The class for exceptions that can occur during the normal operation of the Java Virtual Machine.
    - Other Exceptions: Checked exceptions that need to be declared in a method or constructor's throws clause.
- Error: Represents serious problems that a reasonable application should not try to catch.

```java
public class ExceptionHandling {
  public static void main(String[] args) {
      try {
          // code that may throw an exception
      } catch (ExceptionType1 e1) {
          // code to handle ExceptionType1
      } catch (ExceptionType2 e2) {
          // code to handle ExceptionType2
      } finally {
          // code that will always execute
      }
  }

}

```
## Unchecked Exceptions in Method Overriding
The overriding method can declare any unchecked exceptions (subclasses of RuntimeException or Error) without restrictions.
```java
import java.io.IOException;

class Parent {
  void doThis() {
    // ...
  }
}

public class Main extends Parent {
  @Override
  void doThis() throws ArithmeticException, NumberFormatException, NullPointerException  {
    // no compilation error because it is unchecked exception
  }

}
```
## Checked Exceptions in Method Overriding
- The overriding method can declare the same checked exceptions as the superclass method or any subset (including subclasses) of those exceptions.
- The overriding method cannot declare new checked exceptions or broader checked exceptions that are not declared by the superclass method.

```java
import java.sql.SQLException;

class Parent {
  void doThis() {
    // No exceptions declared
  }
}

public class Main extends Parent {
  @Override
  void doThis() throws SQLException {
    // Compilation error because SQLException is a checked exception
    // and the parent class method does not declare it.
  }
}

```

```java
import java.io.EOFException;
import java.io.FileNotFoundException;

class Parent {
    void doThis() throws IOException  {
        // ...
    }
}

public class Main extends Parent {
    @Override
    void doThis() throws FileNotFoundException, EOFException {
        // No compilation error because FileNotFoundException and EOFException implements the IOException 
    }
}
```

## Exception in Static block 
We cannot throw a checked exception from a static block; doing so will result in a compile-time error. 
However, we can handle checked exceptions within the scope of a static block using try-catch logic 
without rethrowing the exception using the throw keyword. Checked exceptions cannot be propagated from 
static blocks because these blocks are executed only once during compile-time and are not invoked by any method.
- You can throw unchecked exceptions from a static block because they are runtime exceptions. However, 
if such exceptions are not caught and handled by the program, they can lead to termination of the program.

```java
static { 
        try{
            System.out.println("In static block of class A");
            System.out.println(1 / 0); // It will throw java.lang.ArithmeticException
        }catch (Exception e){
            // throw new SQLException(); //this is not possible, it will give compile error, but you can handle through try catch
            System.err.println(e.getMessage());
            throw new NullPointerException(); //this is possible because it is unchecked Exception, but it leads to termination because it is not caught and handled by the program 
        }
    }
```