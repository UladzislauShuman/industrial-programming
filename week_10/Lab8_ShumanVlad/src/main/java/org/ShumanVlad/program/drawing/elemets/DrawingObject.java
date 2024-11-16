package org.ShumanVlad.program.drawing.elemets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingObject
{
    private List<DrawingPoint> points;

    public DrawingObject()
    {
        this.points = new ArrayList<>();
    }
    public DrawingObject(
            BufferedImage image
    )
    {
        this();
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb, true);
                // true для поддержки альфа-канала
                if (color.getAlpha() != 0) {
                    // Проверка на прозрачность
                    this.points.add(new DrawingPoint(color, new Point(x, y)));
                }
            }
        }
    }

    public List<DrawingPoint> getPoints() {return this.points;}

    public void add(DrawingPoint point) {
        points.add(point);
    }

    public void draw(Graphics g)
    {
        for (DrawingPoint point : points)
            point.drawPoint(g);
    }
}
