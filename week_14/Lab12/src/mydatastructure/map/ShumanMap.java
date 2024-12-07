package mydatastructure.map;

import org.ShumanVlad.Constants;
import org.ShumanVlad.interfaces.DataStructureInterface;
import org.ShumanVlad.interfaces.MapInterface;
import org.ShumanVlad.iterators.ShumanMapIterator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Бывают различные Карты, и я решил выбрать
HashMap

За основу моей структуры данных был взят материал из книги
Лафоре Р. Структуры данных и Алгоритмы Java

в книге обсуждались различные примеры Кеширования
в оптимальном решении (если даже не в любом) есть момент
с Коллизией

Чтобы её решить применяют
Открытую адресацию (в моём решении я исп. двойное хеширование)
и
Гнезда (вместо списков в Методе цепочек исп. массивы)
 */
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
        this.buckets = new ArrayList[this.capacity];
        for (int i = 0; i < this.capacity; i++)
        {
            this.buckets[i] = new ArrayList<>();
        }
        this.size = 0;
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
        int newCapacity = nextPrime(this.capacity * Constants.RESIZE_FACTOR);
        ArrayList<ShumanPair<KeyType, ValueType>>[] newBuckets = new ArrayList[newCapacity];
        for (int i = 0; i < newCapacity; i++)
        {
            newBuckets[i] = new ArrayList<>();
        }
        for (ArrayList<ShumanPair<KeyType, ValueType>> bucket : this.buckets)
        {
            for (ShumanPair<KeyType, ValueType> pair : bucket)
            {
                int index = Math.abs(pair.getKey().hashCode() % newCapacity);
                newBuckets[index].add(pair);
            }
        }
        this.capacity = newCapacity;
        this.buckets = newBuckets;
    }
    private int nextPrime(int n)
    {
        while (true)
        {
            if (isPrime(n))
                return n;
            n++;
        }
    }
    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
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
        {
            bucket.clear();
        }
        this.size = 0;
    }

    //разбить на методы
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShumanMap<?, ?> that = (ShumanMap<?, ?>) o;
        return Arrays.equals(this.buckets, that.buckets);
    }

    //разбить на методы
    @Override public String toString()
    {
        StringBuilder sb = new StringBuilder("{");
        for (ArrayList<ShumanPair<KeyType, ValueType>> bucket : this.buckets)
        {
            for (ShumanPair<KeyType, ValueType> pair : bucket)
            {
                sb.append(pair.toString()).append(", ");
            }
        }
        if (sb.length() > 1)
        {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public JList toJList() {
        ArrayList<ShumanPair<KeyType, ValueType>> allPairs = new ArrayList<>();
        for (ArrayList<ShumanPair<KeyType, ValueType>> bucket : this.buckets)
        {
            allPairs.addAll(bucket);
        }
        return new JList(allPairs.toArray());
    }

    //разбить на методы
    @Override
    public void put(KeyType key, ValueType value) {
        if (this.size > this.capacity * Constants.LOAD_FACTOR)
        {
            this.resize();
        }
        int index = hash(key);
        int step = doubleHash(key);
        while (!this.buckets[index].isEmpty())
        {
            if (this.buckets[index].get(0).getKey().equals(key))
            {
                this.buckets[index].get(0).setValue(value);
                return;
            }
            index = (index + step) % this.capacity;
        }
        this.buckets[index].add(new ShumanPair<>(key, value));
        this.size++;
    }

    @Override
    public ValueType get(KeyType key) {
        int index = hash(key);
        int step = doubleHash(key);
        while (!this.buckets[index].isEmpty())
        {
            if (this.buckets[index].get(0).getKey().equals(key))
            {
                return this.buckets[index].get(0).getValue();
            }
            index = (index + step) % this.capacity;
        }
        return null;
    }

    @Override
    public void putAll(MapInterface<KeyType, ValueType> map)
    {
        for (int i = 0; i < ((ShumanMap<KeyType, ValueType>) map).buckets.length; i++)
        {
            for (ShumanPair<KeyType, ValueType> pair : ((ShumanMap<KeyType, ValueType>) map).buckets[i])
            {
                this.put(pair.getKey(), pair.getValue());
            }
        }
    }


    public ShumanMapIterator<KeyType,ValueType> iterator() {
        return new ShumanMapIterator<>(this.buckets);
    }

}
