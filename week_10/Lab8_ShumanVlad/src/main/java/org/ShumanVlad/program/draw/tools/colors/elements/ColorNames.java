package org.ShumanVlad.program.draw.tools.colors.elements;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorNames
{
    private static final Map<Color, String> colorNames;

    static {
        colorNames = new HashMap<>();
        colorNames.put(Color.BLACK, "Black");
        colorNames.put(Color.RED, "Red");
        colorNames.put(Color.BLUE,"Blue");
    }
    public static String getColorName(
            Color color
    )
    {
        String colorName = colorNames.get(color);
        if (colorName != null)
        {
            return colorName;
        }
        return "is Null";
    }
}
