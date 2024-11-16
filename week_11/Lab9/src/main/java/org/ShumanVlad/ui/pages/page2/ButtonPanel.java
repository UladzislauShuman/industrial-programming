package org.ShumanVlad.ui.pages.page2;

/*
Реализовать приложение со следующим интерфейсом (компоновка GridLayout).
При попадании мыши на кнопку меняется ее фон, при перемещении за границу кнопки фон становится старым.
При нажатии по кнопке текст на ней меняется на «Clicked!», при отпускании становится прежним.
Не использовать методы, работающие при перемещении мыши (mouseMoved, mouseDragged)
Сделать общего слушателя для всех кнопок
 */

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel
{
    public ButtonPanel(int size)
    {
        super();
        this.setLayout(new GridLayout(size,size));

        ButtonMouseListener buttonMouseListener = new ButtonMouseListener();
        for (int i = 0; i < size*size;++i)
        {
            JButton button = new JButton(String.valueOf(i+1));
            button.addMouseListener(buttonMouseListener);
            this.add(button);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }
}
