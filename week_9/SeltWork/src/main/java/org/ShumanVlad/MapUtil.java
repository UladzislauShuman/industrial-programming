package org.ShumanVlad;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil
{
    /**
     Make a sorted map whose keys are the given words and whose values are their lengths.
     @param words an array of strings
     @return a map mapping strings to their lengths
     */
    public Map<String, Integer> makeMap(String[] words)
    {
        Map<String, Integer> wordMap = new TreeMap<>();

        for (String word : words)
        {
            wordMap.put(word, word.length());
        }

        return wordMap;
    }
}
