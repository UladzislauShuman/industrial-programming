package org.ShumanVlad.program.drawing.tools.save;

import org.ShumanVlad.program.drawing.DrawingPanel;
import org.ShumanVlad.program.drawing.elemets.DrawingArea;
import org.ShumanVlad.program.drawing.tools.save.elements.OpenDialogButton;
import org.ShumanVlad.program.drawing.tools.save.elements.SaveDialogButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePanel extends JPanel
{
    OpenDialogButton openButton;
    SaveDialogButton saveButton;
    DrawingArea drawingArea;

    public SavePanel(DrawingPanel drawingPanel)
    {
        this.drawingArea = drawingPanel.getDrawingArea();
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
    public DrawingArea getDrawingArea(){return this.drawingArea;}
    public void openImage()
    {
        try
        {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this.getParent()) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(file);
                this.drawingArea.drawImage(image);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
