package visitor;

import mydatastructure.map.ShumanPair;

public interface MapVisitor<KeyValue, ValueType>
{
    void visit(ShumanPair<KeyValue, ValueType> pair);
}
