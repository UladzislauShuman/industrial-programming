package ShimanVlad.ui.pages.page1;

import ui.pages.page1.elements.ButtonPanel;
import ui.pages.page1.elements.ListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListSwitcherPanel<T> extends JPanel
{
    private final ListPanel<T> leftListPanel;
    private final ListPanel<T> rightListPanel;

    public ListSwitcherPanel(List<T> elements)
    {
        super();
        this.setLayout(new BorderLayout());

        this.leftListPanel = new ListPanel<>(elements);
        this.rightListPanel = new ListPanel<>();

        ButtonPanel<T> buttonPanel = new ButtonPanel<>(
                this.leftListPanel,
                this.rightListPanel
        );

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(this.leftListPanel, BorderLayout.WEST);
        this.add(this.rightListPanel, BorderLayout.EAST);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
    }
}
