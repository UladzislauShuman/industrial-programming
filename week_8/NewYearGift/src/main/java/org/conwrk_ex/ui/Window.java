package org.conwrk_ex.ui;

import org.conwrk_ex.objects.present.Present;
import org.conwrk_ex.ui.elements.OpenDialogButton;
import org.conwrk_ex.ui.elements.ReadTextEdit;
import org.conwrk_ex.ui.elements.SaveDialogButton;
import org.conwrk_ex.ui.elements.WriteTextEdit;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private Present present;
    private OpenDialogButton openDialogButton;
    private SaveDialogButton saveDialogButton;
    private ReadTextEdit readTextField;
    private WriteTextEdit writeTextField;

    public Window() throws Exception
    {
        this.setSize(400, 300);
        this.setTitle("Sweets");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(2, 2));

        this.openDialogButton = new OpenDialogButton(this);
        this.add(this.openDialogButton);
        this.saveDialogButton = new SaveDialogButton(this);
        this.add(this.saveDialogButton);

        this.readTextField = new ReadTextEdit(this);
        this.add(this.readTextField);
        this.writeTextField = new WriteTextEdit(this);
        this.add(this.writeTextField);

        this.setLocationRelativeTo(null);
    }
    public Present getPresent(){return this.present;}

    private void addElement(String elementName, Component element)
    {
        JLabel elementLabel = new JLabel(elementName);
        elementLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(elementLabel);
        this.add(element);
    }
    public String getText()
    {
        return this.writeTextField.getText();
    }
    public void setText(String text)
    {
        this.readTextField.setText(text);
        this.writeTextField.setText(text);
    }
}
