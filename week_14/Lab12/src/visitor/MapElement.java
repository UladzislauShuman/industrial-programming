package visitor;

public interface MapElement<KeyType, ValueType>
{
    public void accept(MapVisitor<KeyType, ValueType> visitor);
}
