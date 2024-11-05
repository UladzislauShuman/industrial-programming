package org.ShumanVlad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args)
    {
        List<Toy> toys = new ArrayList<>();
        toys.addAll(ToyUtil.readFromFile("input.txt"));
        toys.add(Toy.parserToy("Book 16 100"));
        System.out.println(ToyUtil.writeToString(toys));
        ToyUtil.writeToFile(toys,"output.txt");

        System.out.println("Sorted by name\n" +
            ToyUtil.writeToString(
                    ToyUtil.takeSortedList(
                            toys,
                            new Comparator<Toy>() {
                                @Override
                                public int compare(Toy o1, Toy o2) {
                                    return o1.getName().compareTo(o2.getName());
                                }
                            }
                    )
            )
        );
        System.out.println( "Sorted by minAge(descending)\n" +
                ToyUtil.writeToString(
                        ToyUtil.takeSortedList(
                                toys,
                                Comparator
                                        .comparing(
                                                Toy::getMinAge,
                                                Comparator.reverseOrder()
                                        )
                        )
                )
        );
        System.out.println("Sorted by maxAge (ascending)\n" +
                ToyUtil.writeToString(
                        ToyUtil.takeSortedList(
                                toys,
                                Comparator.comparing(Toy::getMaxAge)
                        )
                )
        );

        System.out.println( "Sorted by minAge(descending) then maxAge(ascending)\n" +
                ToyUtil.writeToString(
                        ToyUtil.takeSortedList(
                                toys,
                                Comparator
                                        .comparing(
                                                Toy::getMinAge,
                                                Comparator.reverseOrder()
                                        )
                                        .thenComparing(
                                                Toy::getMaxAge,
                                                Comparator.naturalOrder()
                                        )
                        )
                )
        );
        int a = 5, b = 8;
        System.out.println("Filtered by a = 5 and b = 8\n" +
                ToyUtil.writeToString(
                        ToyUtil.takeFilteredList(
                                toys,
                                e->e.getMinAge() >= a && e.getMaxAge() <= b
                        )
                )
        );

        System.out.println(ToyUtil.writeToString(toys));

        try
        {
            System.out.println(
                    "min and max by name Toy-s\n" +
                    ToyUtil.writeToString(
                        ToyUtil.takeMinMaxName(toys)
                    )
            );
        }
        catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }

        MyFrame myFrame = new MyFrame(
                toys,
                ToyUtil.takeSortedList(
                    toys,
                    Comparator
                        .comparing(
                                Toy::getMinAge,
                                Comparator.reverseOrder()
                        )
                ),
                ToyUtil.takeFilteredList(
                        toys,
                        e->e.getMinAge() >= 1 && e.getMaxAge() <= 3
                )
        );
    }
}