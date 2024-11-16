package org.ShumanVlad.program;

import org.ShumanVlad.program.drawing.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private DrawingPanel drawingPanel;
    private JScrollPane scrollPane;

    public Window()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1));

        this.drawingPanel = new DrawingPanel();
        this.scrollPane = new JScrollPane(this.drawingPanel);
        this.add(this.scrollPane);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(800, 600);
        this.setVisible(true);
    }
}
