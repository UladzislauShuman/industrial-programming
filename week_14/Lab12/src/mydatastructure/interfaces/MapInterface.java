package mydatastructure.interfaces;

public interface MapInterface<KeyType, ValueType>
{
    void put(KeyType key, ValueType value);
    ValueType get(KeyType key);
    void putAll(MapInterface<KeyType, ValueType> map);

    void remove(KeyType key, ValueType value);
}
