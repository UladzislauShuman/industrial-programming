package visitor;

public interface VisitorableInterface<Type extends VisitorableInterface<Type>>
{
    void accept(VisitorInterface<Type> visitor);
}
