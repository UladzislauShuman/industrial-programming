package org.conwrk_ex;

import org.conwrk_ex.objects.present.Present;
import org.conwrk_ex.objects.sweet.caramel.Caramel;
import org.conwrk_ex.objects.sweet.caramel.constants.Hardness;
import org.conwrk_ex.objects.sweet.caramel.constants.Taste;
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
            System.out.println(
                    FileWorker.readFile("input.txt").toString()
            );
            Window window = new Window();

        }
        catch (Exception e)
        {
            System.out.println("here");
            System.out.println(e.getMessage());
        }


    }
}