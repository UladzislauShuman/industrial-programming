package org.ShumanVlad.program.drawing.elemets;

import java.awt.*;

public class DrawingPoint extends Point
{
    private Color color;

    public Color getColor(){return this.color;}

    public DrawingPoint(Color color, Point point)
    {
        super(point);
        this.color = color;
    }
    public void drawPoint(Graphics graphics)
    {
        graphics.setColor(this.color);
        graphics.drawOval(this.x, this.y, 5,5);
    }
}
