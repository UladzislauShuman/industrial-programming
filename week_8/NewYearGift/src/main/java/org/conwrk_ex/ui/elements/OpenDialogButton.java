package org.conwrk_ex.ui.elements;

import org.conwrk_ex.tools.FileWorker;
import org.conwrk_ex.ui.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OpenDialogButton extends JButton
{
    private Window parent;
    public OpenDialogButton(Window window) throws Exception
    {
        super("Open");
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
                        window.setText(
                                /////////////////////////////////////
                                FileWorker.readFile(file).toString()
                        );
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
