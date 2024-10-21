package org.example;

import Elements.MyJFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame fr = new MyJFrame("LessonGUI");
        fr.setVisible(true);
        fr.setBounds(100, 100, 400, 500);
        //fr.setSize(new Dimension(300,400));

    }
}