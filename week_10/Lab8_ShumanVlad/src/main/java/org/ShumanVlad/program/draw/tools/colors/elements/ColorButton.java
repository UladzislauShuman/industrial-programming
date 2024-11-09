package org.ShumanVlad.program.draw.tools.colors.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton
{
    private Color buttonColor;
    public ColorButton(
            ColorSubscriber subscriber,
            Color color
    )
    {
        super(ColorNames.getColorName(color));
        this.buttonColor = color;
        this.setBackground(this.buttonColor);
        this.setForeground(Color.WHITE);
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                subscriber.setColor(buttonColor);
            }
        });
    }
}
