package class_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

record Person(String name, String address, Integer age) {
    static Integer adultCount = 0;
    public Person{
        if(age!=null && age>=18){
            adultCount++;
        }
    }

    public boolean isAdult() {
        return age>18;
    }
}


record PersonWithCustomConstructor(String name, String address, String city) {
    static String UNKNOWN_ADDRESS = "Unknown";
    public PersonWithCustomConstructor { // Canonical constructor
        Objects.requireNonNull(name);

    }

    // Additional custom constructor
    public PersonWithCustomConstructor(String name){
        // like this you can pass the default value
       this(name,"India","Chennai");

    }
    public PersonWithCustomConstructor(String name, String city){
        // like this you can pass the default value
        this(name,"India",city);
    }
}

/**
 * 1. Using records, a public constructor, with an argument for each field, is generated for us.
 * 2. We also receive public getters methods, whose names match the name of our field, for free.
 * 3. Equals method is generated for us. This method returns true if the supplied object is of the same type and the values of all of its fields match:
 * 4. You can also use static keyword in Record
 */
public class RecordDemo {
    public static void main(String[] args) {

        Person person = new Person("John","Italy", 23);
        Person person1 = new Person("John","Italy", 23);

        System.out.println(person.address());
        System.out.println(person.equals(person1)); // false
        System.out.println(person.hashCode()+" "+person1.hashCode());

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        System.out.println(personList.get(0).isAdult());


        PersonWithCustomConstructor person2 = new PersonWithCustomConstructor("Doe");
        PersonWithCustomConstructor person3 = new PersonWithCustomConstructor("Doe","Chennai");
        System.out.println(person2.address());
        System.out.println(person2.toString());
        System.out.println(PersonWithCustomConstructor.UNKNOWN_ADDRESS);

    }
}
