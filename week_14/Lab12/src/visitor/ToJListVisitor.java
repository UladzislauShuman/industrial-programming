package visitor;

import mydatastructure.map.ShumanPair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ToJListVisitor<KeyType, ValueType> implements MapVisitor<KeyType, ValueType>
{
    private List<ShumanPair<KeyType, ValueType>> list = new ArrayList<>();

    @Override
    public void visit(ShumanPair<KeyType, ValueType> pair)
    {
        this.list.add(pair);
    }

    public JList getJList(){return new JList(this.list.toArray());}
}
