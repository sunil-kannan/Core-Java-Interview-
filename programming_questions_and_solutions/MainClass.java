package programming_questions_and_solutions;

public class MainClass {

    public static void main(String[] args) {
        MainInterface mainInterface = new MainClassImplementation();
        System.out.println(mainInterface.ClockAngleCalculatorImpl(5,23));
        System.out.println(mainInterface.ClockAngleCalculatorImpl1(5,23));
    }


}
