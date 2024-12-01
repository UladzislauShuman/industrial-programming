package task2.example.strategy.agelist;

import task2.example.toys.Toys;

public interface AgeListStrategy
{
    public Toys getToysForThisAge(Toys toys, int age) throws Exception;
}
