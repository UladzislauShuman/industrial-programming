package mvc.view.buttons;

import mvc.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenDialogButton extends JButton
{
    private Controller controller;

    public OpenDialogButton(Controller frame)
    {
        super("Open");
        this.controller = frame;
        this.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        openDialog();
                    }
                }
        );
    }

    private void openDialog()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (fileChooser.showOpenDialog(this.getParent()) == JFileChooser.APPROVE_OPTION)
        {
            try {
                this.controller.openFile(fileChooser.getSelectedFile().getPath());
            }
            catch (Exception e)
            {}
        }

    }
}
