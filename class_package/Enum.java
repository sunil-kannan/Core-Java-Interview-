package class_package;

enum Laptop{
    Lenovo(2000), Macbook(80040), Azus(), Dell(36000);
    private int price;
    private Laptop(int price){
        this.price = price;
    }

    private Laptop(){
        this.price = 50000;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
public class Enum {
    public static void main(String[] args) {
        Laptop laptop = Laptop.Dell;
        System.out.println(laptop + " : "+laptop.getPrice());

        for(Laptop lap: Laptop.values()){
            System.out.println(lap + " : " +lap.getPrice());
        }
    }
}
