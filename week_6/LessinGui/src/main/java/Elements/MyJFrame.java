package Elements;

import Humans.Student;

import javax.swing.*;

public class MyJFrame extends JFrame
{
    public MyJFrame(String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyJPanel panel = new MyJPanel(new Student("Vlad", 18));
        this.add(panel);

    }
}
