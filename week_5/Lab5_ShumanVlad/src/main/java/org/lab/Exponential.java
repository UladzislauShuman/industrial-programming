package org.lab;

public class Exponential extends Series
{
    public Exponential(double a, double d)
    {
        super(a, d);
    }

    @Override
    public double getElement(int n)
    {
        return this.getA() * Math.pow(this.getD(), n - 1);
    }

}
