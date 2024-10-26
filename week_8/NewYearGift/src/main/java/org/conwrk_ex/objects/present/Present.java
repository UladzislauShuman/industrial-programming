package org.conwrk_ex.objects.present;

import org.conwrk_ex.objects.sweet.Sweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Present
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

    //append

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

    public Present findSweetSugarPercent()
}