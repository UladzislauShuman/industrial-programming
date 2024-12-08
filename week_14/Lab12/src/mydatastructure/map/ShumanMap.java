package mydatastructure.map;


import mydatastructure.Constants;
import mydatastructure.Util;
import mydatastructure.interfaces.DataStructureInterface;
import mydatastructure.interfaces.MapInterface;
import mydatastructure.iterators.ShumanMapIterator;
import visitor.MapVisitor;
import visitor.ToJListModelVisitor;
import visitor.ToJListVisitor;
import visitor.ToStringVisitor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ShumanMap<KeyType, ValueType>
        implements
        DataStructureInterface,
        MapInterface<KeyType, ValueType>
{
    private ArrayList<ShumanPair<KeyType, ValueType>>[] buckets;
    private int size;
    private int capacity;

    //вынести метод
    public ShumanMap()
    {
        this.capacity = Constants.INITIAL_CAPACITY;
        this.size = 0;
        this.buckets = this.createBuckets(this.capacity);
    }

    private ArrayList[] createBuckets(int capacity)
    {
        ArrayList<ShumanPair<KeyType, ValueType>>[] temp_buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++)
            temp_buckets[i] = new ArrayList<>();
        return temp_buckets;
    }

    private int hash(KeyType key)
    {
        return Math.abs(key.hashCode() % this.capacity);
    }
    private int doubleHash(KeyType key)
    {
        return Constants.PRIME_NUMBER - (Math.abs(key.hashCode()) % Constants.PRIME_NUMBER);
    }

    //разделить на методы
    private void resize()
    {
        int newCapacity = Util.nextPrime(this.capacity * Constants.RESIZE_FACTOR);
        ArrayList<ShumanPair<KeyType, ValueType>>[] newBuckets = this.createBuckets(newCapacity);

        try
        {
            for (
                    ShumanMapIterator<KeyType,ValueType> iterator = this.iterator();
                    !iterator.isDone();
                    iterator.next()
            )
            {
                int index = Math.abs(iterator.getCurrentItem().getKey().hashCode() % newCapacity);
                newBuckets[index].add(iterator.getCurrentItem());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        this.capacity = newCapacity;
        this.buckets = newBuckets;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        for (ArrayList<ShumanPair<KeyType, ValueType>> bucket : this.buckets)
            bucket.clear();
        this.size = 0;
    }

    //разбить на методы/visitor
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        ShumanMap<?, ?> that = (ShumanMap<?, ?>) o;
        return Arrays.equals(this.buckets, that.buckets);
    }

    //разбить на методы
    @Override
    public void put(KeyType key, ValueType value) {
        if (isResizingNeeded()) {
            resize();
        }
        int index = findIndex(key);
        if (keyExistsAtIndex(index, key)) {
            updateValueAtIndex(index, value);
        } else {
            addValueAtIndex(index, key, value);
        }
    }

    private boolean isResizingNeeded() {
        return this.size > this.capacity * Constants.LOAD_FACTOR;
    }

    private int findIndex(KeyType key) {
        int index = hash(key);
        int step = doubleHash(key);
        int initialIndex = index;

        while (!buckets[index].isEmpty() && !buckets[index].get(0).getKey().equals(key)) {
            index = (index + step) % capacity;
            if (index == initialIndex) {
                throw new IllegalStateException("Hash table is full");
            }
        }
        return index;
    }

    private boolean keyExistsAtIndex(int index, KeyType key) {
        return !buckets[index].isEmpty() && buckets[index].get(0).getKey().equals(key);
    }

    private void updateValueAtIndex(int index, ValueType value) {
        buckets[index].get(0).setValue(value);
    }

    private void addValueAtIndex(int index, KeyType key, ValueType value) {
        buckets[index].add(new ShumanPair<>(key, value));
        size++;
    }



    @Override
    public ValueType get(KeyType key) {
        int index = hash(key);
        int step = doubleHash(key);
        while (!this.buckets[index].isEmpty())
        {
            if (this.buckets[index].get(0).getKey().equals(key))
                return this.buckets[index].get(0).getValue();
            index = (index + step) % this.capacity;
        }
        return null;
    }

    //MapInterface не содержит метода iterator()
    @Override
    public void putAll(MapInterface<KeyType, ValueType> map)
    {
        for (int i = 0; i < ((ShumanMap<KeyType, ValueType>) map).buckets.length; i++)
            for (ShumanPair<KeyType, ValueType> pair : ((ShumanMap<KeyType, ValueType>) map).buckets[i])
                this.put(pair.getKey(), pair.getValue());
    }

    @Override
    public void remove(KeyType key, ValueType value) {
        int index = hash(key);
        int step = doubleHash(key);
        int initialIndex = index;

        while (!buckets[index].isEmpty()) {
            ShumanPair<KeyType, ValueType> pair = buckets[index].get(0);
            if (key.equals(pair.getKey()) && value.equals(pair.getValue())) {
                buckets[index].remove(0);
                size--;
            }
            index = (index + step) % capacity;
            if (index == initialIndex) {
                break;
            }
        }
    }

    @Override
    public ShumanMapIterator<KeyType,ValueType> iterator() {
        return new ShumanMapIterator<>(this.buckets);
    }

    //применение Visitor
    @Override
    public void accept(MapVisitor<KeyType,ValueType> visitor) {
        try {
            for (ShumanMapIterator<KeyType, ValueType> iterator = this.iterator(); !iterator.isDone(); iterator.next())
            {
                ShumanPair<KeyType, ValueType> currentItem = iterator.getCurrentItem();
                currentItem.accept(visitor);
            }
        } catch (Exception e) {
            System.err.println("accept: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        ToStringVisitor<KeyType, ValueType> visitor = new ToStringVisitor<>();
        this.accept(visitor);
        return visitor.getString();
    }

    @Override
    public JList toJList() {
        ToJListVisitor<KeyType, ValueType> visitor = new ToJListVisitor<>();
        this.accept(visitor);
        return visitor.getJList();
    }

    @Override
    public ListModel getListModel() {
        ToJListModelVisitor<KeyType,ValueType> visitor = new ToJListModelVisitor<>();
        this.accept(visitor);
        return visitor.getJListModel();
    }
}
