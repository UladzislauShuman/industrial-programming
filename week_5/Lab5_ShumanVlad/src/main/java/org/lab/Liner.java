package org.lab;

public class Liner extends Series
{
    public Liner(double a, double d)
    {
        super(a,d);
    }

    @Override
    public double getElement(int n)
    {
        return this.getA() + (n - 1) * this.getD();
    }
}
