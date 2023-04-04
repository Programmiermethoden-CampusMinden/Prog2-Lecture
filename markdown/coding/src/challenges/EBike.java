package challenges;

public class EBike extends Bike {

    public int maxSpeed;
    public int rearGearsCount;
    public int frontGearsCount;

    public EBike(String pn, double p, int ms, int rgc, int fgc, int bc) {
        productName = pn;
        price = p;
        maxSpeed = ms;
        rearGearsCount = rgc;
        frontGearsCount = fgc;
        batteryCapacity = bc;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }
}
