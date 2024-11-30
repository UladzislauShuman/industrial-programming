package ui.panels;

import ui.MyFrame;
import ui.buttons.OpenDialogButton;
import ui.buttons.SaveDialogButton;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel
{
    private OpenDialogButton openDialogButton;
    private SaveDialogButton saveDialogButton;
    private MyFrame frame;

    public ButtonsPanel(MyFrame frame)
    {
        super();
        this.frame = frame;
        this.setLayout(new GridLayout(1,2));
        try {
            this.openDialogButton = new OpenDialogButton(frame);this.add(this.openDialogButton);
            this.saveDialogButton = new SaveDialogButton(frame);this.add(this.saveDialogButton);
        }
        catch (Exception e)
        {
            return;
        }
    }

}
