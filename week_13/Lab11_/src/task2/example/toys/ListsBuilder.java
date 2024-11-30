package task2.example.toys;

import task2.example.strategy.builder.BuilderStrategy;
import task2.example.strategy.filter.StreamFilterStrategy;

import java.util.List;
import java.util.Set;

public class ListsBuilder
{
    public static String toStringLists(Toys toys, int age, int price, BuilderStrategy builderStrategy) throws Exception
    {
        List<Set<Toy>> lists = builderStrategy.buildList(toys, age, price, new StreamFilterStrategy());
        String result = "";
        for (int i = 0; i < lists.size(); ++i)
        {
            result += i + " list\n";
            for(Toy toy : lists.get(i))
                result += toy.toString() + "\n";
            result += "\n";
        }
        return result;
    }
}
