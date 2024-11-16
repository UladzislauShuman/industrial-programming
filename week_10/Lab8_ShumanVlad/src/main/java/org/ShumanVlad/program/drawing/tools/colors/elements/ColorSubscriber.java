package org.ShumanVlad.program.drawing.tools.colors.elements;

import java.awt.*;

//TODO remove it and replace Color
public class ColorSubscriber
{
    private Color color;

    public ColorSubscriber(Color color)
    {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
