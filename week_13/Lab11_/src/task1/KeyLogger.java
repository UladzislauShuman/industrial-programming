package task1;

import javax.swing.*;
import java.awt.*;

public class KeyLogger
    extends JPanel
        implements Observer{

    private final DefaultListModel<String> listModel;
    private final JList<String> lastKeysList;

    public KeyLogger()
    {
        this.listModel = new DefaultListModel<>();
        this.lastKeysList = new JList<>(this.listModel);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(this.lastKeysList), BorderLayout.CENTER);
    }

    @Override
    public void update(String key) {
        this.listModel.addElement(key);
    }
}
