package ui;

import ui.pages.page1.ListSwitcherPanel;
import ui.pages.page2.ButtonPanel;
import ui.pages.page3.ChouseImagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Window extends JFrame
{

    ListSwitcherPanel listSwitcher;
    ButtonPanel buttomPanel;
    ChouseImagePanel chouseImagePanel;

    public Window()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        List<Integer> nums = new ArrayList<Integer>(); for (int i = 0; i < 10;++i){nums.add(i);}
        this.listSwitcher = new ListSwitcherPanel(nums);

        this.buttomPanel = new ButtonPanel(5);

        this.chouseImagePanel = new ChouseImagePanel();

        tabbedPane.addTab("Task1", this.listSwitcher);
        tabbedPane.addTab("Task2", this.buttomPanel);
        tabbedPane.addTab("Task3", this.chouseImagePanel);

        this.add(tabbedPane, BorderLayout.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(800, 600);
        this.setVisible(true);
    }
}
