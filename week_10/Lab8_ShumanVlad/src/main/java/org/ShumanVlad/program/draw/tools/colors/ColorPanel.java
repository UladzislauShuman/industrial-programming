package org.ShumanVlad.program.draw.tools.colors;

import org.ShumanVlad.program.draw.tools.colors.elements.ColorButton;
import org.ShumanVlad.program.draw.tools.colors.elements.ColorSubscriber;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel
{
    private ColorButton blackButton;
    private ColorButton redButton;
    private ColorButton blueButton;

    public ColorPanel(ColorSubscriber subscriber)
    {

        super();
        blackButton = new ColorButton(subscriber,Color.BLACK); this.add(this.blackButton);
        redButton = new ColorButton(subscriber,Color.RED); this.add(this.redButton);
        blueButton = new ColorButton(subscriber,Color.BLUE);this.add(this.blueButton);
    }
}
