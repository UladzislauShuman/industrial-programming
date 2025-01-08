package mvc.view;

import mvc.controller.Controller;
import mvc.view.buttons.AddButton;
import mvc.view.buttons.IntegerTextField;
import mvc.view.buttons.OpenDialogButton;
import mvc.view.buttons.SaveDialogButton;

import javax.swing.*;
import java.awt.*;


public class ButtonsPanel extends JPanel
{
    private AddButton addButton;
    private IntegerTextField textField;
    private OpenDialogButton openDialogButton;
    private SaveDialogButton saveDialogButton;
    private Controller controller;


    public ButtonsPanel(Controller controller)
    {
        super();
        this.controller = controller;
        this.setLayout(new GridLayout(1,4));
        this.textField = new IntegerTextField(); this.add(this.textField);
        this.addButton = new AddButton(this.textField, this.controller);this.add(this.addButton);
        this.openDialogButton = new OpenDialogButton(this.controller);this.add(this.openDialogButton);
        this.saveDialogButton = new SaveDialogButton(this.controller);this.add(this.saveDialogButton);
    }

    }

