package exception_package.exception_handling;

class ParentDemo {
    void doThis() throws NullPointerException {
        // ...
    }
}
public class ExceptionInPolymorphism extends ParentDemo{

    @Override
    void doThis() throws IllegalArgumentException {

    }
}
