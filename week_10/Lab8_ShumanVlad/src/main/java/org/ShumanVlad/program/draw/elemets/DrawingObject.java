package org.ShumanVlad.program.draw.elemets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingObject
{
    private List<DrawingPoint> picture;

    public DrawingObject()
    {
        this.picture = new ArrayList<>();
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
                    this.picture.add(new DrawingPoint(color, new Point(x, y)));
                }
            }
        }
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
