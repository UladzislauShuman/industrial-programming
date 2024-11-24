package org.ShumanVlad.iterators;

import org.ShumanVlad.interfaces.IteratorInterface;
import org.ShumanVlad.map.ShumanPair;

import java.util.ArrayList;

public class ShumanMapIterator<KeyType, ValueType> implements IteratorInterface
{
    private final ArrayList<ShumanPair<KeyType,ValueType>>[] buckets;
    private int bucketIndex = 0;
    private int pairIdex = 0;

    public ShumanMapIterator(ArrayList<ShumanPair<KeyType,ValueType>>[] buckets)
    {
        this.buckets = buckets;
        this.moveToNextNonEmptyBucket();
    }

    private void moveToNextNonEmptyBucket(){
        while (this.bucketIndex < this.buckets.length && this.buckets[this.bucketIndex].isEmpty())
        {
            this.bucketIndex++;
        }
    }

    @Override
    public boolean isDone()
    {
        return this.bucketIndex < this.buckets.length;
    }

    @Override
    public void first()
    {
        this.bucketIndex = 0;
        this.pairIdex = 0;
        this.moveToNextNonEmptyBucket();
    }

    @Override
    public void next() throws Exception
    {
        if(!this.isDone())
        {
            throw new Exception("Больше нет элементов");
        }
        this.pairIdex++;
        if (this.pairIdex >= this.buckets[this.bucketIndex].size())
        {
            this.pairIdex = 0;
            this.bucketIndex++;
            this.moveToNextNonEmptyBucket();
        }
    }

    @Override
    public ShumanPair<KeyType, ValueType> getCurrentItem()
    {
        return this.buckets[this.bucketIndex].get(this.pairIdex);
    }
}
