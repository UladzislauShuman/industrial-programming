package org.conwrk_ex.ui.elements;

import org.conwrk_ex.tools.FileWorker;
import org.conwrk_ex.ui.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private Window parent;

    public SaveDialogButton(Window window) throws Exception
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
                        FileWorker.writeFile(window.getText(),file);
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
