package org.lab;

import java.util.Comparator;

public interface BinaryTreeComparator<T> extends Comparator<T>
{
    @Override
    int compare(T object1, T object2);

    default Comparator<T> makeOrder()
    {
        return (Comparator<T>) Comparator.naturalOrder();
    }
}
