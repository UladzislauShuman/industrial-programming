package org.ShumanVlad.interfaces;

import org.ShumanVlad.map.ShumanPair;

public interface IteratorInterface<KeyType, ValueType>
{
    void first();
    void next() throws Exception;
    boolean isDone();
    ShumanPair<KeyType, ValueType> getCurrentItem();
}
