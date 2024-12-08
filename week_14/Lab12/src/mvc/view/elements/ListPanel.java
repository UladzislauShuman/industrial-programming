package mvc.view.elements;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListPanel<T> extends JPanel
{
    private DefaultListModel<T> listModel;
    private final JList<T> list;

    public ListPanel()
    {
        this.listModel = new DefaultListModel<>();
        this.list = new JList<>(this.listModel);

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(this.list),BorderLayout.CENTER);
    }
    public ListPanel(List<T> elements)
    {
        this();
        this.listModel.addAll(elements);
    }
    //вместо этого сделать методы "вернуть выбранный элемент"
    //это касается кнопок
    public void addElement(T element)
    {
        this.listModel.addElement(element);
    }
    public T getElement(int index)
    {
        return this.listModel.elementAt(index);
    }
    public DefaultListModel<T> getListModel()
    {
        return this.listModel;
    }
    public void setListModel(ListModel<T> model)
    {
        this.list.setModel(model);
        this.listModel = (DefaultListModel<T>) model;
    }

    public JList<T> getList()
    {
        return this.list;
    }
}
