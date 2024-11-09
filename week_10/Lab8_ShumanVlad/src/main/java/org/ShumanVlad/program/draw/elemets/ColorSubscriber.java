package org.ShumanVlad.program.draw.elemets;

import java.awt.*;

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