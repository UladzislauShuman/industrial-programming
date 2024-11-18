package org.ShumanVlad.ui.pages.page3.items;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public enum RadioButtonIcon
{
    DEFAULT(Color.GRAY),
    SELECTED(Color.GREEN),
    HOVER(Color.BLUE),
    PRESSED(Color.RED),
    HOVER_SELECTED(Color.ORANGE);

    private Icon icon;

    RadioButtonIcon(Color color){
        this.icon = createIcon(color);
    }

    public Icon getIcon()
    {
        return this.icon;
    }

    //
    private static Icon createIcon(Color color)
    {
        int size = 64;
        Image image = new BufferedImage(
                size,
                size,
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(color);
        //g2.fillRect(0, 0, size, size);
        g2.drawLine(0,0,size,size);
        g2.drawLine(0, size, size, 0);

        g2.dispose();
        return new ImageIcon(image);
    }
}

