package mvc.view;

import binarytree.BinaryTree;

import javax.swing.*;
import java.awt.*;

public class View extends JTextArea
        implements ViewInterface
{
    private BinaryTree binaryTree;

    public View(BinaryTree binaryTree)
    {
        super();
        this.binaryTree = binaryTree;
        this.setEditable(false);
        this.update();
    }

    @Override
    public void update() {
        this.setText(this.binaryTree.toString());
    }

    @Override
    public Component getComponent() {
        return this;
    }

}