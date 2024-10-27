package org.conwrk_ex.objects.sweet.chocolate;

import org.conwrk_ex.objects.exceptions.CaramelException;
import org.conwrk_ex.objects.exceptions.ChocolateException;
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
                parseType(words[3]),
                parseFilling(words[4])
        );
    }
    private static Filling parseFilling(String filling) throws Exception
    {
        if (filling.isEmpty())
            throw new ChocolateException(ChocolateException.Message.EMPTY_FILLING);
        try
        {
            return Filling.valueOf(filling);
        }
        catch (IllegalAccessError e)
        {
            throw new ChocolateException(ChocolateException.Message.BAD_FILLING);
        }
    }
    private static Type parseType(String type) throws Exception
    {
        if (type.isEmpty())
            throw new ChocolateException(ChocolateException.Message.EMPTY_TYPE);
        try
        {
            return Type.valueOf(type);
        }
        catch (IllegalAccessError e)
        {
            throw new ChocolateException(ChocolateException.Message.BAD_TYPE);
        }
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
