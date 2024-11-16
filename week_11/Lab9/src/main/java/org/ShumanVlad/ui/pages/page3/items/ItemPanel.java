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

        this.add( new JLabel(fox.getIcon()), BorderLayout.CENTER);
        this.foxRadioButton = new FoxRadioButton(fox.getName());
        this.add(this.foxRadioButton, BorderLayout.SOUTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }

    public FoxRadioButton getFoxRadioButton()
    {
        return this.foxRadioButton;
    }
}
