package mvc.model;

import mydatastructure.map.ShumanMap;
import mydatastructure.map.ShumanPair;

import javax.swing.*;

public class MapModel<KeyType, ValueType> implements Model<ShumanPair<KeyType, ValueType>>
{
    private ShumanMap<KeyType,ValueType> map;

    public MapModel() {
        this.map = new ShumanMap<>();
    }

    @Override
    public void addElement(ShumanPair<KeyType, ValueType> pair)
    {
        this.map.put(pair.getKey(), pair.getValue());
        System.out.println("addPair: " + this.map.toString() );
    }

    @Override
    public void removeElement(ShumanPair<KeyType, ValueType> pair)
    {
        this.map.remove(pair.getKey(), pair.getValue());
        System.out.println("remove: " + this.map.toString() );
    }

    @Override
    public DefaultListModel<ShumanPair<KeyType, ValueType>> getListModel()
    {
        DefaultListModel<ShumanPair<KeyType, ValueType>> returnlistModel = new DefaultListModel<>();
        ListModel<ShumanPair<KeyType, ValueType>> mapListModel = map.getListModel();
        for (int i = 0; i < mapListModel.getSize(); i++)
            returnlistModel.addElement(mapListModel.getElementAt(i));
        return returnlistModel;
    }

}
