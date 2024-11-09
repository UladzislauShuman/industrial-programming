package org.ShumanVlad.program.draw.elemets;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingObject
{
    private List<DrawingPoint> picture;

    public DrawingObject()
    {
        this.picture = new ArrayList<>();
    }

    public List<DrawingPoint> getPicture() {return this.picture;}

    public void add(DrawingPoint point) {
        this.picture.add(
                point
        );
    }

    public void draw(Graphics g)
    {
        for (DrawingPoint point : this.picture)
            point.drawPoint(g);
    }
}
