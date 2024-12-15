package org.ShumanVlad.task2.example.strategy.filter;

import org.ShumanVlad.task2.example.toys.Toy;

import java.util.List;

public class StreamFilterStrategy implements FilterStrategy {
    @Override
    public List<Toy> filterToy(List<Toy> toys, int age, int maxPrice) {
        return toys.stream()
                .filter(toy -> toy.isAge(age))
                .toList()
                .stream()
                .filter(toy -> {
                    return toy.getPrice() <= maxPrice;
                })
                .toList();
    }
}
