package mydatastructure.interfaces;


import mydatastructure.map.ShumanPair;

public interface IteratorInterface<KeyType, ValueType>
{
    void first();
    void next() throws Exception;
    boolean isDone();
    ShumanPair<KeyType, ValueType> getCurrentItem();
}
