package org.ShumanVlad;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ToyUtil
{
    public static List<Toy> readFromFile(String filename)
    {
        try
        {
            Scanner scanner = new Scanner(new File(filename));
            List<Toy> toys = new ArrayList<Toy>();
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                toys.add(Toy.parserToy(line));
            }
            return toys;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static String writeToString(List<Toy> toys)
    {

        StringBuilder sb = new StringBuilder();
        toys.forEach(elem->sb.append(elem).append("\n"));
        return sb.toString();
    }

    public static void writeToFile(List<Toy> toys, String filename)
    {
        try(PrintWriter printWriter = new PrintWriter(new File(filename)))
        {
            //FileWriter writer = new FileWriter(new File(filename));
            //writer.write(ToyUtil.writeToString(toys));
            //writer.close();

            printWriter.print(ToyUtil.writeToString(toys));
            printWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static List<Toy> takeSortedList(List<Toy> toys, Comparator<Toy> comparator)
    {
        return toys.stream().sorted(comparator).toList();
    }

    public static List<Toy> takeFilteredList(List<Toy> toys, Predicate<Toy> predicate)
    {
        return toys.stream().filter(predicate).toList();
    }
    public static List<Toy> takeMinMaxName(List<Toy> toys) throws EmptyListException
    {
        if (toys.isEmpty())
            throw new EmptyListException("empty");
        List<Toy> res = new ArrayList<>();
        /*
        min и max работают за O(n)
        а самая быстрая сортировка работает за O(n*log(n))
         */
        res.add(
                toys.stream().min(Comparator.comparing(Toy::getName)).get()
        );
        res.add(
                toys.stream().max(Comparator.comparing(Toy::getName)).get()
        );
        return res;
    }
}
