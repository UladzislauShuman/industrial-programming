package org.conwrk_ex.objects.sweet.chocolate;

import org.conwrk_ex.objects.sweet.Sweet;
import org.conwrk_ex.objects.sweet.caramel.constants.Hardness;
import org.conwrk_ex.objects.sweet.caramel.constants.Taste;
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
    public Chocolate(String line){this(line.split(" "));}
    private Chocolate(String[] words)
    {
        this(
                words[0],
                Integer.parseInt(words[1]),
                Integer.parseInt(words[2]),
                Type.valueOf(words[3]),
                Filling.valueOf(words[4])
        );
    }
    public static Chocolate readLine(String line)
    {
        return new Chocolate(line);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.type + " " +
                this.filling;
    }

}
