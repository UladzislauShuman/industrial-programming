package ui.panels;

import cars.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListPanel<Type> extends JPanel
{
    private final DefaultListModel<Type> listModel;
    private final JList<Type> list;

    public ListPanel()
    {
        this.listModel = new DefaultListModel<>();
        this.list = new JList<>(this.listModel);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(this.list),BorderLayout.CENTER);
    }
    public ListPanel(List<Type> elements)
    {
        this();
        this.listModel.addAll(elements);
    }
    public DefaultListModel<Type> getListModel()
    {
        return this.listModel;
    }
    public JList<Type> getList()
    {
        return this.list;
    }

    public void setList(List<Type> cars)
    {
        this.listModel.clear();
        this.listModel.addAll(cars);
    }
}
