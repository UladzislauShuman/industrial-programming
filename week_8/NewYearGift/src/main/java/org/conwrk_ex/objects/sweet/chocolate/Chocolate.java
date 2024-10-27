package org.conwrk_ex.objects.sweet.chocolate;

import org.conwrk_ex.objects.exceptions.SweetException;
import org.conwrk_ex.objects.sweet.Sweet;
import org.conwrk_ex.objects.sweet.caramel.constants.Hardness;
import org.conwrk_ex.objects.sweet.caramel.constants.Taste;
import org.conwrk_ex.objects.sweet.chocolate.constants.Filling;
import org.conwrk_ex.objects.sweet.chocolate.constants.Type;

public class Chocolate extends Sweet
{
    private Type type;
    private Filling filling;

    public Chocolate (
        String name,
        int weight,
        int sugarPercent,

        Type type,
        Filling filling
        ) throws Exception
    {
        super(name,weight,sugarPercent);
        this.type = type;
        this.filling = filling;
    }
    public Chocolate(String line) throws Exception {this(line.split(" "));}
    private Chocolate(String[] words) throws Exception
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
        try {
            return new Chocolate(line);
        }
        catch (SweetException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.type + " " +
                this.filling;
    }

}
