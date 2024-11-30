package task2.example.app;



import task2.example.app.components.OpenFileDialogButton;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame
{
    private OpenFileDialogButton openButton;
    private JButton editButton;

    public MyWindow() throws Exception
    {
        super();
        this.setSize(400, 400);
        this.setTitle("Toys");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 2));
        this.openButton = new OpenFileDialogButton(this);

        this.setVisible(true);
    }
}
