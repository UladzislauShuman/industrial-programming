package org.ShumanVlad.task2.example.strategy.agelist;

import org.ShumanVlad.task2.example.toys.Toy;
import org.ShumanVlad.task2.example.toys.Toys;

public class NoStreamAgeListStrategy implements AgeListStrategy
{
    @Override
    public Toys getToysForThisAge(Toys toys, int age) throws Exception {
        Toys toysForThisAge = new Toys();
        for (Toy toy : toys.getToys())
            if (toy.isAge(age))
                toysForThisAge.add(toy);
        return toysForThisAge;
    }
}