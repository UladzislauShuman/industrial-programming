package org.ShumanVlad;

import org.ShumanVlad.elemets.ColorPanel;
import org.ShumanVlad.elemets.ColorSubscriber;
import org.ShumanVlad.elemets.DrawingLine;

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
    private List<DrawingLine> lines = new ArrayList<>();
    private ColorSubscriber currentColor = new ColorSubscriber(Color.BLACK);
    private DrawingLine currentLine;

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
        for (DrawingLine line : this.lines)
            line.draw(g);

        if (currentLine != null)
            this.currentLine.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.currentLine = new DrawingLine(this.currentColor.getColor());
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        this.lines.add(this.currentLine);
        this.currentLine = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.currentLine != null)
        {
            this.currentLine.add(new Point(e.getX(),e.getY()));
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
