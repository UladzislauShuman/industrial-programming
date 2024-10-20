package org.example.toys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Toys
{
    private ArrayList<Toy> toys;

    public Toys() throws Exception
    {
        this.toys = new ArrayList<Toy>();
    }
    private Toys(ArrayList<Toy> toys) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        this.toys.addAll(toys);
    }
    private Toys(Toys toys) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        this.toys.addAll(toys.toys);
    }
    public Toys(String fileName) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        CheckData.checkToysData(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null)
        {
            Toy tempToy = new Toy(line);
            this.toys.add(tempToy);
        }
    }

    public Toys add(Toy toy) throws Exception
    {
        this.toys.add(toy);
        return this;
    }
    public int size() throws Exception {return this.toys.size();}
    public Toy get(int i) throws Exception {return this.toys.get(i);}

    public Toys getToysForThisAge(int age) throws Exception
    {
        Toys toys = new Toys();
        for (Toy toy : this.toys)
        {
            if (toy.isAge(age))
                toys.add(toy);
        }
        return toys;
    }

    public Toys sortByPrice() throws Exception
    {
        Collections.sort(this.toys, Comparator.comparingInt(Toy::getPrice));
        return this;
    }

    public Toys sortByPrice(int maxPrice) throws Exception
    {
        this.sortByPrice();

        int left = 0;
        int right = this.size() - 1;
        int lastIndex = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int price = this.get(mid).getPrice();

            if (price <= maxPrice) {
                lastIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        Toys toys = new Toys();
        for (int i = 0; i <= lastIndex; ++i)
        {
            toys.add(this.toys.get(i));
        }
        return toys;
    }
    /*
    Построить различные списки игрушек для заданного возраста,
    суммарная стоимость которых не превосходит заданную величину.
    */
    public String toStringLists(int age, int price) throws Exception
    {
        return ListsBuilder.toStringLists(this, age, price);
    }

    @Override
    public String toString()
    {
        String result = "";
        for (Toy toy : this.toys)
        {
            result += toy.toString() + "\n";
        }
        return result;
    }
}
