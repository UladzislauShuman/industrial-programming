package mydatastructure.iterators;


import mydatastructure.interfaces.IteratorInterface;
import mydatastructure.map.ShumanPair;

import java.util.ArrayList;

public class ShumanMapIterator<KeyType, ValueType> implements IteratorInterface {
    private final ArrayList<ShumanPair<KeyType,ValueType>>[] buckets;
    private int bucketIndex = 0;
    private int pairIndex = 0;

    public ShumanMapIterator(ArrayList<ShumanPair<KeyType,ValueType>>[] buckets) {
        this.buckets = buckets;
        this.moveToNextNonEmptyBucket();
    }

    private void moveToNextNonEmptyBucket() {
        while (this.bucketIndex < this.buckets.length && this.buckets[this.bucketIndex].isEmpty()) {
            this.bucketIndex++;
        }
    }

    @Override
    public boolean isDone() {
        return this.bucketIndex >= this.buckets.length;
    }

    @Override
    public void first() {
        this.bucketIndex = 0;
        this.pairIndex = 0;
        this.moveToNextNonEmptyBucket();
    }

    @Override
    public void next() throws Exception {
        if (isDone()) {
            throw new Exception("Больше нет элементов");
        }

        this.pairIndex++;
        if (this.pairIndex >= this.buckets[this.bucketIndex].size()) {
            this.pairIndex = 0;
            this.bucketIndex++;
            this.moveToNextNonEmptyBucket();
        }
    }

    @Override
    public ShumanPair<KeyType, ValueType> getCurrentItem() {
        return this.buckets[this.bucketIndex].get(this.pairIndex);
    }
}
