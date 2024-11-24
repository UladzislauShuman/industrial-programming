package org.ShumanVlad.map;

public class ShumanPair<KeyType,ValueType>
{
    private KeyType key;
    private ValueType value;

    public ShumanPair(KeyType key, ValueType value)
    {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShumanPair<?, ?> that = (ShumanPair<?, ?>) o;
        return key.equals(that.key); }

    public String toString()
    {
        return "[" + this.key + ", " + this.value + "]";
    }

    public KeyType getKey(){return this.key;}
    public ValueType getValue(){return this.value;}

    public void setValue(ValueType value){this.value = value;}
}
