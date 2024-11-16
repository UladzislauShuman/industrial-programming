package org.ShumanVlad.ui.pages.page3.items;

import javax.swing.*;

public enum Fox
{
    BLACK_FOX("animals/black_fox.png", "Black Fox"),
    CUTE_FOX("animals/cute_fox.png", "Cute Fox"),
    RED_FOX("animals/red_fox.png", "Red Fox"),
    WHITE_FOX("animals/white_fox.png", "White Fox");

    private Icon icon;
    private String name;

    Fox(String path, String name)
    {
        this.icon = new ImageIcon(path);
        this.name = name;
    }

    public Icon getIcon(){
        return this.icon;
    }
    public String getName()
    {
        return this.name;
    }
}
