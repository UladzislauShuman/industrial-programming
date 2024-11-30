package cars;

public abstract class Car
{
    protected String name;
    protected int color;
    protected int rating;

    public Car(
            String name,
            int color,
            int rating
    )
    {
        this.name = name;
        this.color = color;
        this.rating = rating;
    }

    public abstract int getPrice();

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " " + this.name + " " + this.color + " " + this.rating;
    }

    public String getName(){return this.name;}
    public int getColor(){return this.color;}
    public int getRating(){return this.rating;}
}
