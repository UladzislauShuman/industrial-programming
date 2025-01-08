package mvc.view.buttons;
import mvc.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private Controller controller;

    public SaveDialogButton(Controller controller)
    {
        super("Save");
        this.controller = controller;
        SaveDialogButton saveDialogButton = this;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveDialogButton.saveCars();
            }
        });
    }

    public void saveCars()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (fileChooser.showOpenDialog(this.getParent().getParent()) == JFileChooser.APPROVE_OPTION)
            this.controller.saveToFile(fileChooser.getSelectedFile().getPath());
    }
}