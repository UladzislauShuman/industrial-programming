package mvc.model;

import javax.swing.*;

public interface Model<Type>
{
    public void addElement(Type value);
    public void removeElement(Type value);
    public DefaultListModel<Type> getListModel();
}
