package org.ShumanVlad;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            List<Product> products = new ArrayList<>();
            Scanner scanner = new Scanner(new File("input.txt"));

            //не ставить пробелы в файле
            while(scanner.hasNextLine())
                products.add(new Product(
                        scanner.next(),
                        scanner.next(),
                        scanner.nextInt()
                ));
            scanner.close();
            System.out.println("Sorted by Country:\n" + ProductUtil.takeSortedListByCountry(products));
            System.out.println("Amount : " + ProductUtil.getCounts(products));
            System.out.println("Min Amount : " + ProductUtil.findMinCount(products));
            System.out.println("Sorted by Comparator:\n" +
                   ProductUtil.takeView(
                           ProductUtil.takeSortedList(
                                   products,
                                   Comparator
                                           .comparing(Product::getCountry)
                                           .thenComparing(
                                                   Product::getAmount,
                                                   Comparator.reverseOrder()
                                           )
                                   //new ComparatorByCountryCount()
                                   //Comparator.comparing(Product::getCountry)
                           )
                   )
            );
            Comparator<Product> comparator = Comparator.comparing(Product::getCountry).thenComparing(Product::getAmount);

            // страна, список товаров
            Map<String, List<Product>> map = products
                    .stream()
                    .collect(Collectors.groupingBy(Product::getCountry));
            System.out.println("Map:\n'" + map.toString());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}