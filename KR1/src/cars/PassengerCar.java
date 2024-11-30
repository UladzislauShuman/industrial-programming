package cars;

public class PassengerCar extends Car
{
    private int maxSpeed;

    public PassengerCar(
            String name,
            int color,
            int rating,
            int maxSpeed
    ) {
        super(name, color, rating);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int getPrice() {
        return Constants.PASSENGER_CAR_K1.getValue() * this.rating * this.maxSpeed -
                Constants.PASSENGER_CAR_K2.getValue() * this.color;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + this.maxSpeed;
    }
    public int getMaxSpeed(){return this.maxSpeed;}
}
