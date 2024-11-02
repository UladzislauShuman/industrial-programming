package org.ShumanVlad.task2.elements.buttonspanel.button;

import org.ShumanVlad.task2.StudentSurvey;
import org.ShumanVlad.task2.elements.buttonspanel.ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RedButton extends JButton
{
    private ButtonPanel buttonPanel;

    public RedButton(ButtonPanel buttonPanel)
    {
        super("Нет");
        this.buttonPanel = buttonPanel;
        this.setMouseListener();
    }
    private void setMouseListener()
    {
        RedButton this_button = this;
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                this_button.setRandomLocation();
            }
        });
    }

    public void setRandomLocation()
    {
        Point point = this.getLocation();
        System.out.println("setRandomLocation : " + point.toString());
        this.setLocation(this.getRandomPoint(point));
    }

    private Point getRandomPoint(Point point)
    {
        int x = point.x + (int) (Math.random() * 100 - 50);
        int y = point.y + (int) (Math.random() * 100 - 50);
        x = Math.max(0, Math.min(x, buttonPanel.getWidth() - this.getWidth()));
        y = Math.max(0, Math.min(y, buttonPanel.getHeight() - this.getHeight()));
        return new Point(x,y);
    }

}



