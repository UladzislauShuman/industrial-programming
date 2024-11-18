package org.ShumanVlad.ui.pages.page3.items;

import org.ShumanVlad.ui.pages.page3.RadioButtonMouseListener;

import javax.swing.*;

public class FoxRadioButton extends JRadioButton
{
    public FoxRadioButton(String text)
    {
        super(text);
        this.setIcon(RadioButtonIcon.DEFAULT.getIcon());
        this.setSelectedIcon(RadioButtonIcon.SELECTED.getIcon());
        this.setRolloverIcon(RadioButtonIcon.HOVER.getIcon());
        this.setPressedIcon(RadioButtonIcon.PRESSED.getIcon());
        this.setRolloverSelectedIcon(RadioButtonIcon.HOVER_SELECTED.getIcon());

        this.addMouseListener(new RadioButtonMouseListener());
    }
}
