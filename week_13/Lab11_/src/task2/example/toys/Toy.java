package task2.example.toys;

/*
12. Дан файл, содержащий сведения об игрушках:
- название,
- стоимость,
- возрастные границы детей, для которых игрушка предназначена.
...
 */
public class Toy
{
    private String name;
    private int price;
    private int fromAge;
    private int toAge;


    public Toy(String name, int price, int fromAge, int toAge) throws Exception
    {
        this.initialize(name, price, fromAge, toAge);
    }

    public Toy(String line) throws Exception
    {

        String[] lineParts = line.split(",");
        if (lineParts.length != 4)
            throw new Exception("Toy(String) : lineParts.length != 4");
        String name = lineParts[0].trim();
        int price = Integer.parseInt(lineParts[1].trim());
        int fromAge = Integer.parseInt(lineParts[2].trim());
        int toAge = Integer.parseInt(lineParts[3].trim());
        this.initialize(name, price, fromAge, toAge);
    }

    private void initialize(String name, int price, int fromAge, int toAge) throws Exception
    {
        CheckData.checkToyData(name, price,fromAge,toAge);
        this.name = name;
        this.price = price;
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    public int getPrice() {return this.price;}

    public boolean isAge(int age) {return this.fromAge <= age && age <= this.toAge;}

    @Override
    public String toString()
    {
        return  this.name + ", " +
                this.price + ", " +
                this.fromAge + ", " +
                this.toAge;
    }
}
