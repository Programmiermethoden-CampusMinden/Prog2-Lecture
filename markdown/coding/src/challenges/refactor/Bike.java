package challenges.refactor;

public class Bike {

    public String productName;
    public double price;
    public Integer batteryCapacity;

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getGearsCount() {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
