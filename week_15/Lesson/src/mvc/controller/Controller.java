package mvc.controller;

import collection.MyCollection;
import mvc.view.LabelMyView;
import mvc.view.MaxMyView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame
{
    private MyCollection model;
    private LabelMyView labelView;
    private MaxMyView maxMyView;

    public Controller(MyCollection model)
    {
        super();
        this.setVisible(true);
        this.setSize(400, 400);
        this.setTitle("Controller");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.model = model;
        this.labelView = new LabelMyView(this.model);
        this.maxMyView = new MaxMyView(this.model);

        //отедельный класс
        JButton addButton = new JButton("Add");
        this.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = 13;
                model.add(13);
                labelView.update();
                maxMyView.update();
            }
        });

        //метод
        this.setLayout(new GridLayout(3,1));
        this.add(this.labelView);
        this.add(this.maxMyView);
    }
}
