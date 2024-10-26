package org.conwrk_ex.objects.sweet.caramel;

import org.conwrk_ex.objects.sweet.Sweet;
import org.conwrk_ex.objects.sweet.caramel.constants.Hardness;
import org.conwrk_ex.objects.sweet.caramel.constants.Taste;

public class Caramel extends Sweet
{
    private Taste taste;
    private Hardness hardness;

    public Caramel(
            String name,
            int weight,
            int sugarPercent,

            Taste taste,
            Hardness hardness
    )
    {
        super(name,weight,sugarPercent);
        this.taste = taste;
        this.hardness = hardness;
    }
    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.taste + " " +
                this.hardness;
    }
}
