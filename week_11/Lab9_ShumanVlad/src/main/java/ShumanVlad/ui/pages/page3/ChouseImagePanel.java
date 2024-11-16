package ShumanVlad.ui.pages.page3;

import ShumanVlad.ui.pages.page3.items.ItemsPanel;

import javax.swing.*;
import java.awt.*;

/*
Реализовать группу RadioButtons с картинками
выбора/не выбора, помещения мыши над ними, помещения и удержания
(одна картинка на одно действие).
Картинки нарисовать программно через Icon или взять существующие,
инициализировать однократно.
Использовать методы setIcon и т.п.
RadioButtons могут быть об областях Беларуси или т.п.
 */
public class ChouseImagePanel extends JPanel
{
    public ChouseImagePanel()
    {
        super();
        this.setLayout(new BorderLayout());
        this.add(new ItemsPanel());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }
}
