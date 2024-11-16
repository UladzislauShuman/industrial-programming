package org.ShumanVlad.program.drawing.tools;

import org.ShumanVlad.program.drawing.DrawingPanel;
import org.ShumanVlad.program.drawing.tools.colors.ColorPanel;
import org.ShumanVlad.program.drawing.tools.save.SavePanel;

import javax.swing.*;
import java.awt.*;

public class ToolsPanel extends JPanel
{
    private DrawingPanel drawingPanel;
    private ColorPanel colorPanel;
    private SavePanel savePanel;

    public ToolsPanel(DrawingPanel drawingPanel)
    {
        this.drawingPanel = drawingPanel;
        this.colorPanel = new ColorPanel(this.drawingPanel.getCurrentColor());
        this.savePanel = new SavePanel(this.drawingPanel);

        this.setLayout(new FlowLayout());
        this.add(this.colorPanel);
        this.add(this.savePanel);
    }

}
