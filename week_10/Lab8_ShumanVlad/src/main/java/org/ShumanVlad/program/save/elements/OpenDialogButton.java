package org.ShumanVlad.program.save.elements;

import org.ShumanVlad.program.save.SavePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class OpenDialogButton extends JButton
{
    private SavePanel parent;
    public OpenDialogButton(SavePanel window) throws Exception
    {
        super("Open");
        this.parent = window;
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
                this.parent.getParentDP().drawImage(image);
//                Graphics g = this.getParent().getGraphics();
//                g.drawImage(image, 0,0,this);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
