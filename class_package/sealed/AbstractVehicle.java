package class_package.sealed;

public abstract sealed class AbstractVehicle permits Truck{
    protected final String registrationNumber;

    public AbstractVehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
