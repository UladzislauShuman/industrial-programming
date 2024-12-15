package org.ShumanVlad.task2.example.app.components;

import org.ShumanVlad.task2.example.app.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private MyWindow parent;
    private String result; //временно, пока не придумаю куда перекидыать
    public SaveDialogButton(MyWindow myWindow)
    {
        super("Save");
        this.parent = myWindow;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveIntoXML();
            }
        });
    }

    public void saveIntoXML()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (fileChooser.showOpenDialog(this.getParent().getParent()) == JFileChooser.APPROVE_OPTION)
            parent.saveToFile(fileChooser.getSelectedFile().getPath());
    }
}