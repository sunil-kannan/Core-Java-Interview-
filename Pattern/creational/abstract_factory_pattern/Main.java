package Pattern.creational.abstract_factory_pattern;

interface Profession{
    void print();
}
class Teacher implements Profession {

    @Override
    public void print() {
        System.out.println("Teacher profession");
    }
}
class Doctor implements Profession {

    @Override
    public void print() {
        System.out.println("Doctor profession");
    }
}
class TraineeTeacher implements Profession{

    @Override
    public void print() {
        System.out.println("Trainee Teacher profession");
    }
}
class TraineeDoctor implements Profession{

    @Override
    public void print() {
        System.out.println("Trainee Doctor profession");
    }
}

abstract class AbstractFactory{
    abstract Profession getProfession(String typeOfProfession);
}
class TraineeProfessionAbstractFactory extends AbstractFactory{
    @Override
    Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null){
            return null;
        }
        else if(typeOfProfession.equalsIgnoreCase("Doctor")){
            return new TraineeDoctor();
        } else if (typeOfProfession.equalsIgnoreCase("Teacher")) {
            return new TraineeTeacher();
        }
        return  null;
    }
}
class ProfessionAbstractFactory extends AbstractFactory{
    @Override
    Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null){
            return null;
        }
        else if(typeOfProfession.equalsIgnoreCase("Doctor")){
            return new Doctor();
        } else if (typeOfProfession.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        }
        return  null;
    }
}
class AbstractFactoryProducer{
    public static AbstractFactory getProfession(boolean isTrainee){
        if(isTrainee){
            return new TraineeProfessionAbstractFactory();
        }
        else{
            return new ProfessionAbstractFactory();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(true);
        Profession doc = abstractFactory.getProfession("Doctor");
        doc.print();
    }
}
