package org.conwrk_ex.objects.present;

import org.conwrk_ex.objects.sweet.Sweet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Present implements Iterable<Sweet>
{
    private ArrayList<Sweet> sweets;

    public Present()
    {
        this.sweets = new ArrayList<Sweet>();
    }
    public Present(ArrayList<Sweet> sweets)
    {
        this();
        this.sweets.addAll(sweets);
    }
    public Present(Present present)
    {
        this();
        this.sweets.addAll(present.sweets);
    }
    public Present(Sweet ... sweets)
    {
        this.sweets = new ArrayList<Sweet>(Arrays.asList(sweets));
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (Sweet sweet : this.sweets)
            result.append(sweet.toString()).append("\n");
        return result.toString();
    }

    public void add(Sweet sweet)
    {
        this.sweets.add(sweet);
    }

    public Present sortWeight()
    {
        Collections.sort(this.sweets, new Comparator<Sweet>() {
            @Override
            public int compare(Sweet o1, Sweet o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        return this;
    }
    public Present sortSugarPercant()
    {
        Collections.sort(this.sweets, new Comparator<Sweet>() {
            @Override
            public int compare(Sweet o1, Sweet o2) {
                return o1.getSugarPercent() - o2.getSugarPercent();
            }
        });
        return this;
    }
    public Present sort(Comparator<Sweet> comparator)
    {
        Collections.sort(
                this.sweets,
                comparator
        );
        return this;
    }

    public Present findSweetSugarPercent(int minSugarPercent, int maxSugarPersent)
    {
        this.sortSugarPercant();
        Predicate<Sweet> predicate = sweet -> minSugarPercent <= sweet.getSugarPercent() &&
                sweet.getSugarPercent() <= maxSugarPersent;
        return this.find(predicate);
    }
    public Present find(Predicate<Sweet> predicate)
    {
        return new Present(
                new ArrayList<Sweet>(
                        this.sweets.stream().filter(predicate).collect(Collectors.toList())
                )
        );
    }

    public String getStatistics()
    {
        Map<String, Integer> weightMap = new HashMap<>();
        int totalWeight = 0;

        for (Sweet sweet : this.sweets)
        {
            String type = sweet.getClass().getSimpleName();
            weightMap.put(type, weightMap.getOrDefault(type,0) + sweet.getWeight());
            totalWeight += sweet.getWeight();
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : weightMap.entrySet())
        {
            String type = entry.getKey();
            int weight = entry.getValue();
            double percentage = (double) weight / totalWeight * 100;
            result.append(type).append(" ").append(weight).append(" ").append(percentage).append("\n");
        }
        return result.toString();
    }
    @Override
    public Iterator<Sweet> iterator()
    {
        return this.sweets.iterator();
    }
}