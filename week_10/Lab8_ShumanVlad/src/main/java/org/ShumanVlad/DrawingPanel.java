package org.ShumanVlad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/*
коллекция line
где line -- это один мазок пользователя
 */
public class DrawingPanel
        extends JPanel
        implements MouseListener,
        MouseMotionListener
{
    private List<Point> line = new ArrayList<>();
    public DrawingPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : this.line)
        {
            g.drawOval(point.x, point.y, 5,5);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.line.add(new Point(e.getX(),e.getY()));
        this.repaint();
        Graphics gr = this.getGraphics();
        gr.drawOval(e.getX(),e.getY(),);
        //эканомно
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
