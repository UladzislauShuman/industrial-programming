package task1;

import javax.swing.*;
import java.awt.*;


public class KeyBoard
    extends JPanel
        implements Observer
{
    private JLabel lastKeyLabel;

    public KeyBoard()
    {
        super();
        this.lastKeyLabel = new JLabel("Last Key: ");
        this.setLayout(new BorderLayout());
        this.add(this.lastKeyLabel, BorderLayout.CENTER);
    }

    @Override
    public void update(String key) {
        this.lastKeyLabel.setText("Last Key: " + key);
    }
}
