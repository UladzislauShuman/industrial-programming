package mvc.controller;

import binarytree.BinaryTree;
import mvc.view.ButtonsPanel;
import mvc.view.View;
import mvc.view.ViewInterface;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller extends JFrame
{
    private BinaryTree model;
    private List<ViewInterface> views = new ArrayList<>();

    public Controller(BinaryTree model, ViewInterface view)
    {
        super();
        this.setVisible(true);
        this.setSize(400, 400);
        this.setTitle("Controller");
        this.model = model;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.addView(view);

        ButtonsPanel buttonPanel = new ButtonsPanel(this);
        this.add(buttonPanel);
    }

    public void addElementToModel(Integer item)
    {
        model.add(item);
        notifyViews();
    }
    public void addView(ViewInterface view)
    {
        this.views.add(view);
        this.add(view.getComponent());
    }
    protected void notifyViews()
    {
        for(ViewInterface view: this.views)
            view.update();
    }
    public void openFile(String filename) throws IOException {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.open(filename);

        this.model.clearAll();
        this.model.addAll(binaryTree);
        this.notifyViews();
    }
    public void saveToFile(String filename)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write(this.model.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
