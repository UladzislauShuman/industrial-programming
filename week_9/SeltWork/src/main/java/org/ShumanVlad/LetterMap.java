package org.ShumanVlad;

import java.util.Map;
import java.util.TreeMap;

public class LetterMap
{
    public Map<String, Integer> makeLetterMap(String str)
    {
        Map<String, Integer> letterMap = new TreeMap<>();

        for (char ch : str.toCharArray())
        {
            String letter = String.valueOf(ch);
            Integer count = letterMap.get(letter);
            if (count == null)
            {
                letterMap.put(letter, 1);
            }
            else
            {
                letterMap.put(letter, count + 1);
            }
        }

        return letterMap;
    }
}

