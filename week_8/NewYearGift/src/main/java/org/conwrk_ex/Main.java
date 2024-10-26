package org.conwrk_ex;

import org.conwrk_ex.objects.present.Present;
import org.conwrk_ex.objects.sweet.caramel.Caramel;
import org.conwrk_ex.objects.sweet.caramel.constants.Hardness;
import org.conwrk_ex.objects.sweet.caramel.constants.Taste;
import org.conwrk_ex.objects.sweet.chocolate.Chocolate;
import org.conwrk_ex.objects.sweet.chocolate.constants.Filling;
import org.conwrk_ex.objects.sweet.chocolate.constants.Type;

public class Main {
    public static void main(String[] args)
    {
        Chocolate chocolate = new Chocolate(
                "Spartak",
                45,
                50,
                Type.MILK_CHOCOLATE,
                Filling.NOTHING
        );
        Present present = new Present(
                chocolate,
                new Caramel(
                        "Orange",
                        10,
                        40,
                        Taste.ORANGE,
                        Hardness.HARD
                ),
                new Chocolate(
                        "Red hat",
                        100,
                        50,
                        Type.MILK_CHOCOLATE,
                        Filling.NUTS
                )
        );
        System.out.println(present.sortWeight().toString());

    }
}