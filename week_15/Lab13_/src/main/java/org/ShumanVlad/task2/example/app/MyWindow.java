package org.ShumanVlad.task2.example.app;



import org.ShumanVlad.task2.example.app.components.OpenFileDialogButton;
import org.ShumanVlad.task2.example.app.components.SaveDialogButton;
import org.ShumanVlad.task2.example.toys.Toys;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame
{
    private Toys toys;
    private OpenFileDialogButton openButton;
    private SaveDialogButton saveButton;
    private JTextArea textArea;

    public MyWindow() throws Exception
    {
        super();
        this.setSize(400, 400);
        this.setTitle("Toys");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.toys = new Toys();

        this.textArea = new JTextArea(); this.add(this.textArea, BorderLayout.CENTER);
        this.openButton = new OpenFileDialogButton(this); this.add(this.openButton, BorderLayout.EAST);
        this.saveButton = new SaveDialogButton(this); this.add(this.saveButton, BorderLayout.WEST);

        this.setVisible(true);
    }

    public void openFile(String filename) {
        try {
            this.toys = new Toys(); //Reinitialize
            //this.toys.loadFromXMLSAX(filename);
            this.toys.loadFromXMLStAX(filename);
            this.textArea.setText(this.toys.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) {
        try {
            this.toys.saveToXML(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
