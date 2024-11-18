package org.ShumanVlad.ui.pages.page3.items;

import javax.swing.*;
import java.awt.*;

public class ItemsPanel  extends JPanel
{
    public ItemsPanel()
    {
        super();
        this.setLayout(new GridLayout(4,1));

        ButtonGroup buttonGroup = new ButtonGroup();
        for (Fox fox : Fox.values())
        {
            ItemPanel itemPanel = new ItemPanel(fox);
            this.add(itemPanel);
            buttonGroup.add(itemPanel.getFoxRadioButton());
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }
}
