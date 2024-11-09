package org.ShumanVlad.program.draw;

import org.ShumanVlad.program.draw.elemets.*;
import org.ShumanVlad.program.save.SavePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
коллекция line
где line -- это один мазок пользователя
 */
/*
1. Создать фрейм с областью для рисования (мышь оставляет след).
 Добавить кнопки для выбора одного из трех цветов пера.
 Картинка разноцветная.
2. Осуществить рисование на панели со скроллингом.
3. Реализовать диалог сохранения/открытия файла в формате картинки (использовать класс ImageIO).
 */
public class DrawingPanel
        extends JPanel
        implements MouseListener,
        MouseMotionListener
{
    private List<DrawingObject> objects = new ArrayList<>();
    private DrawingObject currentObject;

    private ColorSubscriber currentColor = new ColorSubscriber(Color.BLACK);
    //private SavePanel savePanel;

    public DrawingPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        ColorPanel colorPanel = new ColorPanel(this.currentColor);
        SavePanel savePanel = new SavePanel(this);

        this.setLayout(new BorderLayout());
        this.add(colorPanel, BorderLayout.NORTH);
        //this.add(savePanel,BorderLayout.CENTER);
        //все равно занимает больше места, чем нужно
        //нужно взять другой элемент для отсчёта
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DrawingObject object : this.objects)
            object.draw(g);

        if (this.currentObject != null)
            this.currentObject.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.currentObject = new DrawingObject();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        this.objects.add(this.currentObject);
        this.currentObject = null;
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.currentObject != null)
        {
            this.currentObject.add(
                    new DrawingPoint(
                            this.currentColor.getColor(),
                            e.getPoint()
                    )
            );
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void drawImage(BufferedImage image)
    {
        Graphics g = this.getGraphics();
        g.drawImage(image, 0,0,this);
    }


}
