package ui.buttons;

import ui.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenDialogButton extends JButton
{
    private MyFrame frame;

    public OpenDialogButton(MyFrame frame)
    {
        super("Open");
        this.frame = frame;
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
            this.frame.updateFrame(fileChooser.getSelectedFile().getPath());
        }
    }
}
