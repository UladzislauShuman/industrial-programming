package org.ShumanVlad.task2.example.strategy.builder;

import org.ShumanVlad.task2.example.strategy.filter.FilterStrategy;
import org.ShumanVlad.task2.example.toys.Toy;
import org.ShumanVlad.task2.example.toys.Toys;

import java.util.List;
import java.util.Set;

public interface BuilderStrategy
{
    List<Set<Toy>> buildList(
            Toys toys,
            int age,
            int maxPrice,
            FilterStrategy strategy
    ) throws Exception;
}
