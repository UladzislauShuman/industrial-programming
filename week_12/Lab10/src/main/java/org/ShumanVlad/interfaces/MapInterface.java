package org.ShumanVlad.interfaces;

public interface MapInterface<KeyType, ValueType>
{
    void put(KeyType key, ValueType value);
    ValueType get(KeyType key);
    void putAll(MapInterface<KeyType, ValueType> map);
}
