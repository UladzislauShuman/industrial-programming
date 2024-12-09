package mvc.controller;

import collection.MyCollection;
import mvc.view.MyLabelView;

import javax.swing.*;
import java.awt.*;

public class Controller extends JFrame
{
    private MyCollection model;
    private MyLabelView labelView;

    public Controller(MyCollection model)
    {
        super();
        this.setVisible(true);
        this.setSize(400, 400);
        this.setTitle("Controller");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.model = model;
        this.labelView = new MyLabelView(this.model);

        //метод
        this.setLayout(new GridLayout(3,1));
        this.add(this.labelView);
    }
}
