package visitor;

public class StringVisitor implements MyVisitor<Integer>
{
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void visit(Integer item)
    {
        this.stringBuilder.append(item).append(" ");
    }

    public String getString() {
        return stringBuilder.toString();
    }
}
