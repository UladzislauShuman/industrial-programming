package org.conwrk_ex.tools;

import java.util.HashMap;
import java.util.function.Function;

import org.conwrk_ex.objects.sweet.caramel.Caramel;
import org.conwrk_ex.objects.sweet.chocolate.Chocolate;

public class SweetChooser
{

    private static HashMap<String, Function<String, Object>> map = new HashMap<>();
    static  {
        map.put("Chocolate" , Chocolate::readLine);
        map.put("Caramel", Caramel::readLine);
    }
    public static Function<String,Object> getFunction(String sweetType)
    {
        return map.get(sweetType);
    }
}
