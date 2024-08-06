package class_package;

enum Laptop {
    Lenovo(2000), Macbook(80040), Azus(), Dell(36000);

    // Private variable to store the price
    private int price;

    // Constructor with price parameter
    private Laptop(int price) {
        System.out.println("Enum Laptop parameterized constructor called: " + this);
        this.price = price;
    }

    // Default constructor setting price to 50000 for Azus
    private Laptop() {
        System.out.println("Enum Laptop default constructor called: " + this);
        this.price = 50000;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }
}

interface A {
    void doThis();
}

// Main class containing an enum Week implementing interface A
public class Enum {
    enum Week implements A {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        @Override
        public void doThis() {
            System.out.println("Do this method called");
        }
        Week() {
            System.out.println("Constructor called: " + this);
        }
    }

    public static void main(String[] args) {
        // Create an instance of Week enum
        Week week = Week.Wednesday; // You are creating object for one, but it will invoke the constructor
        week.doThis();
        System.out.println(week);
        System.out.println(week.ordinal()); // This will print the index of the enum constant

        // Create an instance of Laptop enum
        Laptop laptop = Laptop.Dell;
        System.out.println(laptop + " : " + laptop.getPrice());
//        Laptop laptop1 = Laptop.Azus;

//        System.out.println(laptop1 + " : " + laptop1.getPrice());

        // Iterate over all Laptop enum values and print their prices
//        for (Laptop lap : Laptop.values()) {
//            System.out.println(lap + " : " + lap.getPrice());
//        }
    }
}
