package visitor;


import mydatastructure.map.ShumanPair;
import javax.swing.*;

public class ToJListModelVisitor<KeyType, ValueType> implements MapVisitor<KeyType, ValueType>{

    private DefaultListModel<ShumanPair<KeyType, ValueType>> listModel = new DefaultListModel<>();

    @Override
    public void visit(ShumanPair<KeyType, ValueType> pair)
    {
        this.listModel.addElement(pair);
    }

    public DefaultListModel<ShumanPair<KeyType, ValueType>> getJListModel(){return this.listModel;}
}
