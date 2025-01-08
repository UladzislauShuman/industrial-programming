package mvc.view.buttons;

import mvc.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton
{
    private IntegerTextField textField;
    private Controller controller;

    public AddButton(
            IntegerTextField textField,
            Controller controller
    )
    {
        super("Add");
        this.textField = textField;
        this.controller = controller;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addElementToModel(Integer.parseInt(textField.getText()));
            }
        });
    }
}
