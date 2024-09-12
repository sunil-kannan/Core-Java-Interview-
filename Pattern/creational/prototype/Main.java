package Pattern.creational.prototype;

import java.util.Hashtable;


abstract class Profession implements Cloneable{
    abstract void print();


    @Override
    public Profession clone() {
        try {
            return (Profession) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
class Teacher extends Profession {

    @Override
    public void print() {
        System.out.println("Teacher profession");
    }
}
class Doctor extends Profession {

    @Override
    public void print() {
        System.out.println("Doctor profession");
    }
}
class Engineer extends Profession {

    @Override
    public void print() {
        System.out.println("Engineer profession");
    }
}
class ProfessionCache{
    private static Hashtable<Integer, Profession> professionHashtable = new Hashtable<>();
    public static Profession getClonedProfession(int id){
        Profession cachedProf = professionHashtable.get(id);
        return cachedProf.clone();
    }
    public static void loadProfessionCache(){
        Doctor doctor = new Doctor();
        professionHashtable.put(1, doctor);
        Engineer engineer = new Engineer();
        professionHashtable.put(2, engineer);
        Teacher teacher = new Teacher();
        professionHashtable.put(3, teacher);
    }
}
public class Main {
    public static void main(String[] args) {
        ProfessionCache.loadProfessionCache();
        Profession doctor = ProfessionCache.getClonedProfession(1);
        System.out.println(doctor);
        Profession engineer = ProfessionCache.getClonedProfession(2);
        System.out.println(engineer);
        Profession teacher = ProfessionCache.getClonedProfession(3);
        System.out.println(teacher);
        // it will clone the object and not creating the object, so it is efficient
        Profession doctor1 = ProfessionCache.getClonedProfession(1);
        System.out.println(doctor1);
    }
}
