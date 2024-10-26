package org.conwrk_ex.objects.sweet.chocolate;

import org.conwrk_ex.objects.sweet.Sweet;
import org.conwrk_ex.objects.sweet.chocolate.constants.Filling;
import org.conwrk_ex.objects.sweet.chocolate.constants.Type;

public class Chocolate extends Sweet
{
    private Type type;
    private Filling filling;

    public Chocolate(
        String name,
        int weight,
        int sugarPercent,

        Type type,
        Filling filling
        )
    {
        super(name,weight,sugarPercent);
        this.type = type;
        this.filling = filling;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.type + " " +
                this.filling;
    }

}
