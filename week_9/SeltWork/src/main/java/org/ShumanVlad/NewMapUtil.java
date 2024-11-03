package org.ShumanVlad;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class NewMapUtil
{
    /**
     Make a sorted map whose keys are the word lengths words and whose values are
     the sets of the words with the given lengths. The map and sets should be sorted.
     @param words an array of strings
     @return a map mapping strings to their lengths
     */
    public Map<Integer, TreeSet<String>> makeMap(String[] words)
    {
        Map<Integer, TreeSet<String>> lengthMap = new TreeMap<>();

        for (String word : words)
        {
            int length = word.length();
            TreeSet<String> set = lengthMap.getOrDefault(length, new TreeSet<>());
            set.add(word);
            lengthMap.put(length, set);
        }

        return lengthMap;
    }
}
