package iterator;

public interface IteratorInterface<Type>
{
    void first();
    void next();
    boolean isDone();
    Type getCurrentItem();
}
