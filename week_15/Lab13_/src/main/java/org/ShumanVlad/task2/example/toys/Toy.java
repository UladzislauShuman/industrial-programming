package org.ShumanVlad.task2.example.toys;

/*
12. Дан файл, содержащий сведения об игрушках:
- название,
- стоимость,
- возрастные границы детей, для которых игрушка предназначена.
...
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "toy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Toy
{
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "price")
    private int price;
    @XmlElement(name = "fromAge")
    private int fromAge;
    @XmlElement(name = "toAge")
    private int toAge;

    public  Toy(){}

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

    public boolean isAge(int age) {return this.fromAge <= age && age <= this.toAge;}

    @Override
    public String toString()
    {
        return  this.name + ", " +
                this.price + ", " +
                this.fromAge + ", " +
                this.toAge;
    }

    public int getPrice() {return this.price;}
    public String getName(){return this.name;}
    public int getFromAge() {
        return fromAge;
    }
    public int getToAge() {
        return toAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setToAge(int toAge) {
        this.toAge = toAge;
    }
    public void setFromAge(int fromAge) {
        this.fromAge = fromAge;
    }
}
