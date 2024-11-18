package org.ShumanVlad.ui.pages.page3.items;

import javax.swing.*;
import java.awt.*;

public class ItemPanel extends JPanel
{
    private FoxRadioButton foxRadioButton;

    public ItemPanel(Fox fox)
    {
        super();
        this.setLayout(new BorderLayout());

        this.foxRadioButton = new FoxRadioButton(fox.getName());
        this.add(this.foxRadioButton, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }

    public FoxRadioButton getFoxRadioButton()
    {
        return this.foxRadioButton;
    }
}
