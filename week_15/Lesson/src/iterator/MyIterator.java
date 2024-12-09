package iterator;

public interface MyIterator<Type>
{
    void first();
    void next();
    boolean isDone();
    Type getCurrentItem();
}
