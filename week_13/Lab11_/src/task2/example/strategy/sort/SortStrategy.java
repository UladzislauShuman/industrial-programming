package task2.example.strategy.sort;

import task2.example.toys.Toys;

public interface SortStrategy
{
    public Toys sort(Toys toys) throws Exception;
}
