package mvc.view.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel
{
    private JButton addButton;
    private JButton removeButton;

    public ButtonsPanel(JFrame frame)
    {
        super();;
        this.addButton = new JButton("Add"); this.add(this.addButton);
        this.removeButton = new JButton("Remove");this.add(this.removeButton);
    }
    public void addAddButtonListener(ActionListener listener)
    {
        this.addButton.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener)
    {
        this.removeButton.addActionListener(listener);
    }
}
