package org.ShumanVlad.program.draw.elemets;

import org.ShumanVlad.program.draw.tools.colors.elements.ColorSubscriber;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DrawingArea
        extends JPanel
        implements MouseListener,
        MouseMotionListener
{
    private List<DrawingObject> objects = new ArrayList<>();//заменится BufferedImage(?)
    private DrawingObject currentObject;
    private BufferedImage backGroundImage;

    private ColorSubscriber currentColor = new ColorSubscriber(Color.BLACK);
    public ColorSubscriber getCurrentColor(){return this.currentColor;}


    public DrawingArea()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.backGroundImage != null)
            g.drawImage(this.backGroundImage,0,0,this.getWidth(), this.getHeight(), this);

        for (DrawingObject object : this.objects)
            object.draw(g);

        if (this.currentObject != null)
            this.currentObject.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.currentObject = new DrawingObject();
    }


    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (this.currentObject != null)
        {
            DrawingPoint currentPoint = new DrawingPoint(
                    this.currentColor.getColor(),
                    e.getPoint()
            );
            this.currentObject.add(currentPoint);
            Graphics graphics = this.getGraphics();
            currentPoint.drawPoint(graphics);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.objects.add(this.currentObject);
        this.currentObject = null;
    }


    public void drawImage(BufferedImage image)
    {
        this.objects.add(new DrawingObject(image));
        this.repaint();
    }

    public void setImageBackground(BufferedImage image)
    {
        this.backGroundImage = image;
        this.repaint();
    }

    public void saveImage(File file)
    {
        try
        {
            BufferedImage image = new BufferedImage(
                    this.getWidth(),
                    this.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );
            Graphics2D g2d = image.createGraphics();

            this.paint(g2d);
            g2d.dispose();

            ImageIO.write(image, "png", file);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
}
