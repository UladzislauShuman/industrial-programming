package task2.example.strategy.builder;

import task2.example.strategy.filter.FilterStrategy;
import task2.example.toys.Toy;
import task2.example.toys.Toys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToysBuilderStrategy implements BuilderStrategy
{
    @Override
    public List<Set<Toy>> buildList(
            Toys toys,
            int age,
            int maxPrice,
            FilterStrategy filterStrategy
    ) throws Exception {
        List<Toy> filteredToysList =  filterStrategy.filterToy(
          toys.getToys(), age, maxPrice
        );
        Toys filteredToys = new Toys(filteredToysList);

        Set<Set<Toy>> combinations = new HashSet<>();
        generateLists(filteredToys, new HashSet<>(), combinations, 0, maxPrice, 0);
        return new ArrayList<>(combinations);
    }
    private static void generateLists(
            Toys toys,
            Set<Toy> currentCombination,
            Set<Set<Toy>> combinations,
            int startIndex,
            double maxPrice,
            double currentPrice
    ) throws Exception
    {
        if (currentPrice > maxPrice) {
            return;
        }

        if (!currentCombination.isEmpty()) {
            combinations.add(new HashSet<>(currentCombination));
        }

        for (int i = startIndex; i < toys.size(); i++) {
            Toy toy = toys.get(i);
            if (toy.getPrice() + currentPrice <= maxPrice) {
                currentCombination.add(toy);
                generateLists(toys, currentCombination, combinations, i + 1, maxPrice, currentPrice + toy.getPrice());
                currentCombination.remove(toy);
            }
        }
    }
}
