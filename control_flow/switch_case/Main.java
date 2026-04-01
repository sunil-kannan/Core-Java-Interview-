package control_flow.switch_case;

class Employee{
    String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee(String department) {
        this.department = department;
    }
}

public class Main {

    // Until Java 7 only integers could be used in switch case and this had been the standard for a long time:
    public void java7(int value){
        switch (value) {
            case 1:
                System.out.println("One");
                break;
            case 5:
                System.out.println("five");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    // In Java 8 strings & enum were introduced in case values and switch statements started to evolve
    public void java8(String day){
        switch (day) {
            case "Monday":
                System.out.println("Week day");
                break;
            case "Tuesday":
                System.out.println("Week day");
                break;
            case "Wednesday":
                System.out.println("Week day");
                break;
            case "Thursday":
                System.out.println("Week day");
                break;
            case "Friday":
                System.out.println("Week day");
                break;
            case "Saturday":
                System.out.println("Weekend");
                break;
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Unknown");
        }

        enum DAYS {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
        DAYS days = DAYS.SUNDAY;
        switch (days) {
            case MONDAY:
                System.out.println("Weekdays");
                break;
            case TUESDAY:
                System.out.println("Weekdays");
                break;
            case WEDNESDAY:
                System.out.println("Weekdays");
                break;
            case THURSDAY:
                System.out.println("Weekdays");
                break;
            case FRIDAY:
                System.out.println("Weekdays");
                break;
            case SATURDAY:
                System.out.println("Weekends");
                break;
            case SUNDAY:
                System.out.println("Weekends");
                break;
            default:
                System.out.println("Unknown");
        }
    }


    /**
     * Java 12 further enhanced the switch statement and introduced switch expressions as a preview feature.
     *
     * It introduced a flurry of new features:
     *
     * You can return values from a switch block and hence switch statements became switch expressions
     * You can have multiple values in a case label
     * You can return value from a switch expression through the arrow operator or through the “break” keyword
     */
    public String java12(String day, int method){

        if(method == 0){
            return  switch (day) {
                case "Monday":
                    yield  "Weekday";
                case "Tuesday":
                    yield "Weekday";
                case "Wednesday":
                    yield "Weekday";
                case "Thursday":
                    yield "Weekday";
                case "Friday":
                    yield "Weekday";
                case "Saturday":
                    yield "Weekend";
                case "Sunday":
                    yield "Weekend";
                default:
                    yield "Unknown";
            };
        } else if (method == 1) {
            return  switch (day) {
                case "Monday"-> "Week day";
                case "Tuesday"-> "Week day";
                case "Wednesday"->"Week day";
                case "Thursday"->"Week day";
                case "Friday"->"Week day";
                case "Saturday"-> "Weekend";
                case "Sunday"-> "Weekend";
                default->"Unknown";
            };
        } else if (method == 2) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    return "Weekday";
                case "Saturday":
                case "Sunday":
                    return "Weekend";
                default:
                    return "Unknown";
            }

        }
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Unknown";
        };
    }

    public String java17(Object obj, int way){

        // pattern matching and catch null values
        if(way == 0) {

            return switch (obj) {
                case null -> "Object is null";
                case Integer i -> "It is an integer";
                case String s -> "It is a string";
                case Employee s -> "It is a Employee";
                default -> "It is none of the known data types";
            };
        }

        // Guarded patterns
//        return switch (obj) {
//            case Integer i -> "It is an integer";
//            case String s -> "It is a string";
//            case Employee employee && employee.getDepartment().equals("IT") -> "IT Employee";
//            default -> "It is none of the known data types";
//        };

        return null;

    }

    public static void main(String[] args) {
    }


}