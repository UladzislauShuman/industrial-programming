package mvc.model;

import mydatastructure.map.ShumanMap;
import mydatastructure.map.ShumanPair;

import javax.swing.*;

public class MapModel<KeyType, ValueType> implements Model
{
    private ShumanMap<KeyType,ValueType> map;

    public MapModel() {
        this.map = new ShumanMap<>();
    }


    public void addPair(ShumanPair<KeyType, ValueType> pair)
    {
        this.map.put(pair.getKey(), pair.getValue());
        System.out.println("addPair: " + this.map.toString() );
    }

    public void removePair(ShumanPair<KeyType, ValueType> pair)
    {
        this.map.remove(pair.getKey(), pair.getValue());
        System.out.println("remove: " + this.map.toString() );
    }

    public DefaultListModel getMapJList() {
        return (DefaultListModel) this.map.toJList().getModel();
    }
    public DefaultListModel<ShumanPair<KeyType, ValueType>> getMapListModel()
    {
        DefaultListModel<ShumanPair<KeyType, ValueType>> listModel = new DefaultListModel<>();
        JList<ShumanPair<KeyType, ValueType>> jList = map.toJList();
        ListModel<ShumanPair<KeyType, ValueType>> model = jList.getModel();
        for (int i = 0; i < model.getSize(); i++)
        {
            listModel.addElement(model.getElementAt(i));
        }
        return listModel;
    }

}
