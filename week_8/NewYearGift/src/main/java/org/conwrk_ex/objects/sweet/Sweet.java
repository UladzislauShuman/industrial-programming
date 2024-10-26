package org.conwrk_ex.objects.sweet;

public abstract class Sweet
{
    private int weight;
    private int sugarPercent;
    private String name;

    public Sweet(String name, int weight, int sugarPercent)
    {
        this.name = name;
        this.weight = weight;
        this.sugarPercent = sugarPercent;
    }

    public int getWeight()
    {
        return this.weight;
    }
    public int getSugarPercent()
    {
        return this.sugarPercent;
    }

    public double getSugarMass()
    {
        return this.weight * this.sugarPercent / 100.0;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " " +
                this.name + " " +
                this.weight + " " +
                this.sugarPercent;
    }

}