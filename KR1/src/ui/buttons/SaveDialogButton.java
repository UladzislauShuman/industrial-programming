package ui.buttons;
import ui.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveDialogButton extends JButton
{
    private MyFrame frame;

    public SaveDialogButton(MyFrame frame) throws Exception
    {
        super("Save");
        this.frame = frame;
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
            this.frame.saveCarsInFile(fileChooser.getSelectedFile().getPath());
    }
}