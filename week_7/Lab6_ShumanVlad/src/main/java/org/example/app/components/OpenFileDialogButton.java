package org.example.app.components;

import org.example.app.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OpenFileDialogButton extends JButton
{
    private MyWindow parent;
    private String result; //временно, пока не придумаю куда перекидыать
    public OpenFileDialogButton(MyWindow myWindow) throws Exception
    {
        super("Open");
        this.parent = myWindow;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = chooser.showOpenDialog(myWindow);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    File file = chooser.getSelectedFile();
                    try
                    {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null)
                        {
                            sb.append(line).append("\n");
                        }
                        //куда-то sb закинть
                        br.close();
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






