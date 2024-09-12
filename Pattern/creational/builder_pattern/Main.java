package Pattern.creational.builder_pattern;

class Home{
    String Floor;
    String Terrace;
    String Walls;
}
interface Builder{
    void buildFloor();
    void buildWalls();
    void buildTerrace();
    Home getComplexHomeObject();
}
class EarthQuakeResistentBuilder implements Builder{

    @Override
    public void buildFloor() {

    }

    @Override
    public void buildWalls() {

    }

    @Override
    public void buildTerrace() {

    }

    @Override
    public Home getComplexHomeObject() {
        return null;
    }
}
class FloodResistentBuilder implements Builder{

    @Override
    public void buildFloor() {

    }

    @Override
    public void buildWalls() {

    }

    @Override
    public void buildTerrace() {

    }

    @Override
    public Home getComplexHomeObject() {
        return null;
    }
}

class Director{
    private Builder builder;
    public Director(Builder builderType){
        this.builder = builderType;
    }
    public Home getComplexHomeObject(){
        return this.builder.getComplexHomeObject();
    }
    public void manageRequiredHomeConstruction(){
        this.builder.buildFloor();
        this.builder.buildWalls();
        this.builder.buildTerrace();
    }
}
public class Main {
    public static void main(String[] args) {
        EarthQuakeResistentBuilder builder = new EarthQuakeResistentBuilder();
        Director director = new Director(builder);
        Home home = director.getComplexHomeObject();
    }
}
