package task2.example.strategy.filter;

import task2.example.toys.Toy;

import java.util.List;

public interface FilterStrategy
{
    List<Toy> filterToy(List<Toy> toys, int age, int maxPrice);
}
