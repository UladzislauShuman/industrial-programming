package ui.pages.page1.elements;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel<T> extends JPanel
{
    public ButtonPanel(ListPanel<T> leftListPanel, ListPanel<T> rightListPanel)
    {
        super();
        this.setLayout(new BorderLayout());

        FromToListButton leftButton = new FromToListButton(">",leftListPanel,rightListPanel);
        FromToListButton rightButton = new FromToListButton("<",rightListPanel,leftListPanel);

        this.add(rightButton, BorderLayout.NORTH);
        this.add(leftButton,BorderLayout.SOUTH);

    }
}
