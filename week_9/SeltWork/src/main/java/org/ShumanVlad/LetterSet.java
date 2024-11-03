package org.ShumanVlad;

import java.util.Set;
import java.util.TreeSet;

public class LetterSet
{
    public Set<String> makeLetterSet(String str)
    {
        Set<String> letterSet = new TreeSet<>();

        for (char ch : str.toCharArray())
        {
            letterSet.add(String.valueOf(ch));
        }

        return letterSet;
    }
}
