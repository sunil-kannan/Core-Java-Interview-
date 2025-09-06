package java8_features.lambda;

@FunctionalInterface // there is no need to write this, but for understanding we are writing this
interface CalculatorWithVoid {
    void calculate();
}

@FunctionalInterface
interface CalculatorWithParameter {
    void calculate(int a, int b);
}

@FunctionalInterface
interface CalculatorWithReturn {
    int calculate(int a, int b);
}


public class FunctionalInterfaceWithLambda {

    public static void main(String[] args) {
        CalculatorWithVoid calculator = () -> {
            System.out.println("Answer: " + (3 + 5));
        };
        calculator.calculate();

        CalculatorWithParameter calculator1 = (int a, int b) -> System.out.println("Answer: " + (a + b));
        calculator1.calculate(6, 6);

        CalculatorWithReturn calculator2 = (int a, int b) -> a + b;
        System.out.println("Answer: "+calculator2.calculate(4, 5));

    }
}
