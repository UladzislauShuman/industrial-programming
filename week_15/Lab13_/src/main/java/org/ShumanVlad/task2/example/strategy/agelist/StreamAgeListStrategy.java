package org.ShumanVlad.task2.example.strategy.agelist;

import org.ShumanVlad.task2.example.toys.Toys;

public class StreamAgeListStrategy implements AgeListStrategy {
    @Override
    public Toys getToysForThisAge(Toys toys, int age) throws Exception{
        return new Toys(toys.getToys().stream().filter(toy -> toy.isAge(age)).toList());
    }
}
