package mydatastructure.interfaces;

import javax.swing.*;

public interface DataStructureInterface
{
    int size();
    boolean isEmpty();
    void clear();
    //int equals();
    //String toString();
    JList toJList();
    ListModel getListModel();
}
