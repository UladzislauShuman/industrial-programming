package visitor;

import mydatastructure.map.ShumanPair;

public class ToStringVisitor<KeyType, ValueType> implements MapVisitor<KeyType, ValueType>
{
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void visit(ShumanPair<KeyType, ValueType> pair) {
        this.stringBuilder.append(pair.toString()).append(", ");
    }

    public String getString()
    {
        this.deleteLastComma();
        return this.stringBuilder.toString();
    }

    private void deleteLastComma()
    {
        if (this.stringBuilder.length() > 2)
            this.stringBuilder.setLength(this.stringBuilder.length() - 2);//удалить последнюю запятую
    }
}
