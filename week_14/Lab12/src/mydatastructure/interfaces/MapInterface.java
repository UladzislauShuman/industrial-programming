package mydatastructure.interfaces;

import visitor.MapVisitor;

public interface MapInterface<KeyType, ValueType>
{
    void put(KeyType key, ValueType value);
    ValueType get(KeyType key);
    void putAll(MapInterface<KeyType, ValueType> map);

    void remove(KeyType key, ValueType value);
    IteratorInterface<KeyType, ValueType> iterator();
    void accept(MapVisitor<KeyType,ValueType> visitor);
}
