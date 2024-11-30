package cars;

public enum Constants
{
    PASSENGER_CAR_K1(1),
    PASSENGER_CAR_K2(1),

    BUS_CAR_K1(1),
    BUS_CAR_K2(1),
    BUS_CAR_K3(1);


    private int value;
    Constants(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
