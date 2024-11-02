package org.ShumanVlad;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductUtil
{
    public static int getCounts(List<Product> products)
    {
        return products
                .stream()
                .mapToInt(Product::getAmount)
                .sum();
    }
    public static int findMinCount(List<Product> products)
    {
        return products
                .stream()
                .mapToInt(Product::getAmount)
                .min()
                .getAsInt();
    }

    public static List<Product> takeSortedListByCountry(List<Product> products)
    {
           return products
                   .stream()
                   .sorted(
                           Comparator.comparing(Product::getCountry)
                   )
                   .toList();
    }
    public static List<Product> takeSortedList(List<Product> products, Comparator<Product> comparator)
    {
        return products
                .stream()
                .sorted(
                        comparator
                )
                .collect(Collectors.toList());
                //.toList();
    }

    public static String takeView(List<Product> products)
    {
        return  products
                .stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
    }

    public static List<Product> takeByPredicate(List<Product> products, Predicate<Product> predicate)
    {
        return products
                .stream()
                .filter(predicate)
                .toList();
    }
}
