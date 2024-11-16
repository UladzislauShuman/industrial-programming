package org.ShumanVlad.program.drawing;

import org.ShumanVlad.program.drawing.elemets.*;
import org.ShumanVlad.program.drawing.tools.ToolsPanel;
import org.ShumanVlad.program.drawing.tools.colors.elements.ColorSubscriber;

import javax.swing.*;
import java.awt.*;

/*
1. Создать фрейм с областью для рисования (мышь оставляет след).
 Добавить кнопки для выбора одного из трех цветов пера.
 Картинка разноцветная.
2. Осуществить рисование на панели со скроллингом.
3. Реализовать диалог сохранения/открытия файла в формате картинки (использовать класс ImageIO).
 */
public class DrawingPanel
        extends JPanel
{
    private ToolsPanel toolsPanel;
    private DrawingArea drawingArea;
    public DrawingArea getDrawingArea(){return this.drawingArea;}
    public ColorSubscriber getCurrentColor(){return this.drawingArea.getCurrentColor();}

    public DrawingPanel()
    {
        this.drawingArea = new DrawingArea();
        this.toolsPanel = new ToolsPanel(this);

        this.setLayout(new BorderLayout());
        this.add(this.toolsPanel,BorderLayout.NORTH);
        this.add(this.drawingArea, BorderLayout.CENTER);

        //все равно занимает больше места, чем нужно
        //нужно взять другой элемент для отсчёта
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }
}
