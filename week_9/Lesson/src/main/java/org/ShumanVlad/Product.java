package org.ShumanVlad;

public class Product
{
    private String name;
    private String country;
    private int amount;

    public Product(
            String name,
            String country,
            int amount
    )
    {
        this.name = name;
        this.country = country;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return this.name + " " +
                this.country + " " +
                this.amount;
    }

}
