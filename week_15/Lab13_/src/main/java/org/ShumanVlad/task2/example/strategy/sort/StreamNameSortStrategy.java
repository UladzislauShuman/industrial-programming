package org.ShumanVlad.task2.example.strategy.sort;

import org.ShumanVlad.task2.example.toys.Toy;
import org.ShumanVlad.task2.example.toys.Toys;

import java.util.Comparator;

public class StreamNameSortStrategy implements SortStrategy
{
    @Override
    public Toys sort(Toys toys) throws Exception {
        return new Toys(toys.getToys().stream().sorted(Comparator.comparing(Toy::getName)).toList());
    }
}
