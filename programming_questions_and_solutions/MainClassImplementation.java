package programming_questions_and_solutions;

public class MainClassImplementation implements MainInterface{
    @Override
    public String ClockAngleCalculatorImpl(int hours, int minutes) { // simplest method but complicated to understand
        if(hours<0 || hours>13){
            return "Invalid hours";
        }
        else if(minutes<0 || minutes>61){
            return "Invalid minutes";
        }
        double hoursInDegree = hours * 30;
        double minsInDegree = minutes * 6;
        System.out.println(30 * hours - 5.5 * minutes);
        double angle = hoursInDegree > minsInDegree ? 30 * hours - 5.5 * minutes : 5.5 * minutes - 30 * hours ;
        return "Angle at "+hours+":"+minutes+" is "+angle + " degrees";
    }

    public String ClockAngleCalculatorImpl1(int hours, int minutes) { // complex way
        if(hours<0 || hours>13){
            return "Invalid hours";
        }
        else if(minutes<0 || minutes>61){
            return "Invalid minutes";
        }
        System.out.println(30 * hours - 5.5 * minutes);
        double minutesAngle;
        double hoursAngle;
        double angle;
        minutesAngle = minutes == 0 ? 360 : minutes * 6;
        hoursAngle = (double) (360 * hours) /12  + (((double) 360 /12)*minutesAngle)/360;
        angle = hoursAngle > minutesAngle ? hoursAngle - minutesAngle : minutesAngle - hoursAngle;
        return "Angle at "+hours+":"+minutes+" is "+angle + " degrees";
    }
}
