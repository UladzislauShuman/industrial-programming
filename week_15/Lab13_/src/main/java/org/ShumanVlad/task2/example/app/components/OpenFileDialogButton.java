package org.ShumanVlad.task2.example.app.components;



import org.ShumanVlad.task2.example.app.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileDialogButton extends JButton
{
    private MyWindow parent;
    public OpenFileDialogButton(MyWindow myWindow) throws Exception
    {
        super("Open");
        this.parent = myWindow;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openXMLFile();
            }
        });
    }

    public void openXMLFile()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (chooser.showOpenDialog(this.parent) == JFileChooser.APPROVE_OPTION)
            parent.openFile(chooser.getSelectedFile().getPath());
    }
}






