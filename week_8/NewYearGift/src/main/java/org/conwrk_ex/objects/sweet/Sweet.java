package org.conwrk_ex.objects.sweet;

import org.conwrk_ex.objects.exceptions.SweetException;

public abstract class Sweet
{
    private int weight;
    private int sugarPercent;
    private String name;

    public Sweet(String name, int weight, int sugarPercent) throws Exception
    {
        this.setName(name);
        this.setWeight(weight);
        this.setSugarPercent(sugarPercent);
    }
    private void setName(String name) throws Exception
    {
        if (name.isEmpty())
            throw new SweetException(SweetException.Message.EMPTY_NAME);
        this.name = name;
    }
    private void setWeight(int weight) throws Exception
    {
        if (weight < 0)
            throw new SweetException(SweetException.Message.WEIGHT_LESS_ZERO);
        this.weight = weight;
    }
    private void setSugarPercent(int sugarPercent) throws Exception
    {
        if (sugarPercent < 0 || sugarPercent > 100)
            throw new SweetException(SweetException.Message.BAD_SUGAR_PERCENT);
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