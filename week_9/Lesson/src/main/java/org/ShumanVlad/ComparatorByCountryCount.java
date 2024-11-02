package org.ShumanVlad;

import java.util.Comparator;

public class ComparatorByCountryCount implements Comparator<Product>
{
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getCountry().equals(o2.getCountry()))
        {
            return  o1.getAmount() - o2.getAmount();
        }
        return o1.getCountry().compareTo(o2.getCountry());
    }
}
