package Pattern.creational.factory_pattern;

interface Profession{
    void print();
}
class Teacher implements Profession{

    @Override
    public void print() {
        System.out.println("Teacher profession");
    }
}
class Doctor implements Profession{

    @Override
    public void print() {
        System.out.println("Doctor profession");
    }
}
class Engineer implements Profession{

    @Override
    public void print() {
        System.out.println("Engineer profession");
    }
}
class ProfessionFactory{
    public Profession getProfession(String typeOfProfession){
        if(typeOfProfession == null){
            return null;
        }
        else if(typeOfProfession.equalsIgnoreCase("Doctor")){
            return new Doctor();
        } else if (typeOfProfession.equalsIgnoreCase("Engineer")) {
            return new Engineer();
        } else if (typeOfProfession.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        ProfessionFactory profession = new ProfessionFactory();
        Profession doc = profession.getProfession("Doctor");
        doc.print();
    }
}
