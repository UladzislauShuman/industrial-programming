package org.ShumanVlad.program.save.elements;

import org.ShumanVlad.program.save.SavePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private SavePanel parent;

    public SaveDialogButton(SavePanel window) throws Exception
    {
        super("Save");
        this.parent = window;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = chooser.showOpenDialog(window);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    File file = chooser.getSelectedFile();
                    try
                    {
                        System.out.println("future");

                    }
                    catch (Exception exception)
                    {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        });
    }
}
