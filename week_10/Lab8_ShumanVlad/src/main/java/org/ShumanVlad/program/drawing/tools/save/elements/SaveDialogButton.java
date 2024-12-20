package org.ShumanVlad.program.drawing.tools.save.elements;

import org.ShumanVlad.program.drawing.tools.save.SavePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private SavePanel savePanel;

    public SaveDialogButton(SavePanel savePanel) throws Exception
    {
        super("Save");
        this.savePanel = savePanel;
        SaveDialogButton saveDialogButton = this;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveDialogButton.saveImage();
            }
        });
    }

    public void saveImage()
    {
        try
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            if (fileChooser.showOpenDialog(this.getParent().getParent()) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                this.savePanel.getDrawingArea().saveImage(file);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
