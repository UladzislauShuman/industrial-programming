package org.ShumanVlad;

public class Toy
{

    private String name;
    private int minAge;
    private int maxAge;

    public Toy(
            String name,
            int minAge,
            int maxAge
    )
    {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMaxAge() {return maxAge;}
    public void setMaxAge(int maxAge) {this.maxAge = maxAge;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getMinAge() {return minAge;}
    public void setMinAge(int minAge) {this.minAge = minAge;}

    @Override
    public String toString()
    {
        return this.name + " " +
                this.minAge + " " +
                this.maxAge;
    }

    public static Toy parserToy(String line)
    {
        //можно и сканером
        String[] words = line.split(" ");
        return new Toy(
                words[0],
                Integer.parseInt(words[1]),
                Integer.parseInt(words[2])
        );
    }
}
