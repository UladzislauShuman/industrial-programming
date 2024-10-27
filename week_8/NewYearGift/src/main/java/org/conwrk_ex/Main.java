package org.conwrk_ex;

import org.conwrk_ex.objects.exceptions.SweetException;
import org.conwrk_ex.objects.sweet.chocolate.Chocolate;
import org.conwrk_ex.objects.sweet.chocolate.constants.Filling;
import org.conwrk_ex.objects.sweet.chocolate.constants.Type;
import org.conwrk_ex.tools.FileWorker;
import org.conwrk_ex.ui.Window;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Chocolate chocolate = new Chocolate(
                    "name",
                    10,
                    100,
                    Type.MILK_CHOCOLATE,
                    Filling.NOTHING
            );
            System.out.println(
                    FileWorker.readFile("input.txt").toString()
            );
            System.out.println(
                    FileWorker.readFile("input.txt").getStatistics()
            );
            Window window = new Window();

        }
        catch (SweetException e)
        {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("here");
            System.out.println(e.getMessage());
        }
    }
}