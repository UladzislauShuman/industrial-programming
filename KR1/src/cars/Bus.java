package cars;

public class Bus extends Car{
    private int seatCount;
    private int doorCount;

    public Bus(
            String name,
            int color,
            int rating,
            int seatCount,
            int doorCount
    )
    {
        super(name, color, rating);
        this.doorCount = doorCount;
        this.seatCount = seatCount;
    }

    @Override
    public int getPrice() {
        return Constants.BUS_CAR_K1.getValue() *
                this.rating * this.doorCount +
            Constants.BUS_CAR_K2.getValue() * this.seatCount -
            Constants.BUS_CAR_K3.getValue() * this.color;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + this.seatCount + " " + this.doorCount;
    }
    public int getSeatCount(){return this.seatCount;}
    public int getDoorCount(){return this.doorCount;}
}
