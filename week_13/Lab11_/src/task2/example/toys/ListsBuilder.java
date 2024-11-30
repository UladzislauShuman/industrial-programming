package task2.example.toys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListsBuilder
{
    public static String toStringLists(Toys toys, int age, int price) throws Exception
    {
        List<Set<Toy>> lists = ListsBuilder.buildLists(toys,age,price);//this.buildLists(age, price);
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

    public static List<Set<Toy>> buildLists(Toys toys, int age, int maxPrice) throws Exception {
        Toys filteredToys = new Toys();
        filteredToys = toys.getToysForThisAge(age).sortByPrice(maxPrice);

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
