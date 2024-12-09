package iterator;

public interface MyIterable<Type>
{
    MyIterator<Type> createIterator();
}
