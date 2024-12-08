package mvc.view;

import mvc.view.elements.ListPanel;
import mydatastructure.map.ShumanPair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MapView<KeyType, ValueType> extends JFrame
{
    private JButton addButton;
    private JButton removeButton;
    private ListPanel<ShumanPair<KeyType, ValueType>> listPanel;

    public MapView()
    {
        super();
        this.setSize(400, 400);
        this.setTitle("MVC ShumanMap");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        this.addButton = new JButton("Add"); controlPanel.add(this.addButton);
        this.removeButton = new JButton("Remove");controlPanel.add(this.removeButton);
        this.add(controlPanel, BorderLayout.NORTH);

        this.listPanel = new ListPanel<>();
        this.add(this.listPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setListModel(DefaultListModel<ShumanPair<KeyType, ValueType>> model)
    {
        this.listPanel.setListModel(model);
    }

    public ShumanPair<KeyType, ValueType> getSelectedPair() {
        int selectedIndex = this.listPanel.getList().getSelectedIndex();
        System.err.println("getSelectedPair: " + "before");
        if (selectedIndex != -1) {
            System.err.println("getSelectedPair: " + selectedIndex);
            ShumanPair<KeyType, ValueType> pair = this.listPanel.getElement(selectedIndex);
            System.err.println("getSelectedPair: " + "got pair");
            return pair;
        } else {
            System.err.println("getSelectedPair: " + "-1");
            return null;
        }
    }



    public void addAddButtonListener(ActionListener listener)
    {
        this.addButton.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener)
    {
        this.removeButton.addActionListener(listener);
    }
    public ShumanPair<KeyType, ValueType> getNewPairInput()
    {
        KeyType key = (KeyType) JOptionPane.showInputDialog(this, "Enter key:");
        ValueType value = (ValueType) JOptionPane.showInputDialog(this, "Enter value:");
        return new ShumanPair<>(key, value);
    }

    public ListPanel<ShumanPair<KeyType,ValueType>> getListPanel() {
        return listPanel;
    }
}
