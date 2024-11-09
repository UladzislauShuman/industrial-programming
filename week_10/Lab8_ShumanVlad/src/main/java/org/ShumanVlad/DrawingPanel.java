package org.ShumanVlad;

import org.ShumanVlad.elemets.ColorPanel;
import org.ShumanVlad.elemets.ColorSubscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private List<Point> line = new ArrayList<>();
    private ColorSubscriber currentColor = new ColorSubscriber(Color.BLACK);

    public DrawingPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        ColorPanel colorPanel = new ColorPanel(this.currentColor);

        this.setLayout(new BorderLayout());
        this.add(colorPanel, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.currentColor.getColor());
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
        gr.drawOval(e.getX(),e.getY(),5,5);
        //эканомно
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
