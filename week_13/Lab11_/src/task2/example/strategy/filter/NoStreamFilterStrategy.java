package task2.example.strategy.filter;

import task2.example.toys.Toy;

import java.util.ArrayList;
import java.util.List;

public class NoStreamFilterStrategy implements FilterStrategy
{
    @Override
    public List<Toy> filterToy(List<Toy> toys, int age, int maxPrice) {
        List<Toy> filteredToys = new ArrayList<>();
        for (Toy toy : toys)
            if(toy.isAge(age))
                if(toy.getPrice() <= maxPrice)
                    filteredToys.add(toy);
        return filteredToys;
    }
}
