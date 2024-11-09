package org.ShumanVlad.program.draw.tools.save;

import org.ShumanVlad.program.draw.DrawingPanel;
import org.ShumanVlad.program.draw.tools.save.elements.OpenDialogButton;
import org.ShumanVlad.program.draw.tools.save.elements.SaveDialogButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePanel extends JPanel
{
    OpenDialogButton openButton;
    SaveDialogButton saveButton;
    DrawingPanel drawingPanel;
    public SavePanel(DrawingPanel drawingPanel)
    {
        this.drawingPanel = drawingPanel;
        try
        {
            this.saveButton = new SaveDialogButton(this);this.add(this.saveButton);
            this.openButton = new OpenDialogButton(this);this.add(this.openButton);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public DrawingPanel getParentDP(){return this.drawingPanel;}
    public void openImage()
    {
        try
        {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this.getParent()) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(file);
                this.drawingPanel.drawImage(image);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
