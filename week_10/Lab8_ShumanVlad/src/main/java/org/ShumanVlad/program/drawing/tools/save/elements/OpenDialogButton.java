package org.ShumanVlad.program.drawing.tools.save.elements;

import org.ShumanVlad.program.drawing.tools.save.SavePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class OpenDialogButton extends JButton
{
    private SavePanel savePanel;
    public OpenDialogButton(SavePanel savePanel) throws Exception
    {
        super("Open");
        this.savePanel = savePanel;
        OpenDialogButton openDialogButton = this;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openDialogButton.openImage();
            }
        });
    }
    public void openImage()
    {
        try
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            if (fileChooser.showOpenDialog(this.getParent().getParent()) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(file);
                //this.savePanel.getParentDP().drawImage(image);
                this.savePanel.getDrawingArea().setImageBackground(image);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
