package org.ShumanVlad.ui.pages.page3.items;

import org.ShumanVlad.ui.pages.page3.RadioButtonMouseListener;

import javax.swing.*;

public class FoxRadioButton extends JRadioButton
{
    public FoxRadioButton(String text)
    {
        super(text);
        this.setIcon(Icons.DEFAULT.getIcon());
        this.setSelectedIcon(Icons.SELECTED.getIcon());
        this.setRolloverIcon(Icons.HOVER.getIcon());
        this.setPressedIcon(Icons.PRESSED.getIcon());
        this.setRolloverSelectedIcon(Icons.HOVER_SELECTED.getIcon());

        this.addMouseListener(new RadioButtonMouseListener());
    }
}
