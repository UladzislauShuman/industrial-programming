package visitor;


public interface VisitorInterface<Type extends VisitorableInterface>
{
    void visit(Type item);
}
