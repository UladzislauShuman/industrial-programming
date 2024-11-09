package org.ShumanVlad.program.save;

import org.ShumanVlad.program.draw.DrawingPanel;
import org.ShumanVlad.program.save.elements.OpenDialogButton;
import org.ShumanVlad.program.save.elements.SaveDialogButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePanel extends JPanel
{
    OpenDialogButton openButton;
    SaveDialogButton saveButton;
    DrawingPanel parent;
    public SavePanel(DrawingPanel parent)
    {
        this.parent = parent;
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
    public DrawingPanel getParentDP(){return this.parent;}
    public void openImage()
    {
        try
        {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this.getParent()) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(file);
                this.parent.drawImage(image);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
