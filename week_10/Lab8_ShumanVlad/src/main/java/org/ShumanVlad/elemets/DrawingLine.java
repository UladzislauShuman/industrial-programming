package org.ShumanVlad.elemets;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingLine
{
    private List<Point> line;
    private Color color;

    public DrawingLine(
            Color color
    )
    {
        this.color = color;
        this.line = new ArrayList<>();
    }

    public Color getColor() {return this.color;}
    public void setColor(Color color) {this.color = color;}
    public List<Point> getLine() {return this.line;}

    public void add(Point point) {this.line.add(point);}

    public void draw(Graphics g)
    {
        g.setColor(this.color);
        for (Point point : this.line)
        {
            g.drawOval(point.x, point.y, 5,5);
        }
    }
}
