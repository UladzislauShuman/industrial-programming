package org.ShumanVlad;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NewSetUtil
{
    /**
     Determine the strings that are unique to words1 and words2
     @param words1 an array of strings
     @param words2 an array of strings
     @return a list of two sets: the words that are in words1 but not in words2,
     and the words that are in words2 but not in words1. The sets should be sorted.
     */
    public static List<Set<String>> uniqueInEach(String[] words1, String[] words2)
    {
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();
        Set<String> uniqueInWords1 = new TreeSet<>();
        Set<String> uniqueInWords2 = new TreeSet<>();

        for (String word : words1) {
            set1.add(word);
        }
        for (String word : words2) {
            set2.add(word);
        }

        for (String word : set1) {
            if (!set2.contains(word)) {
                uniqueInWords1.add(word);
            }
        }

        for (String word : set2) {
            if (!set1.contains(word)) {
                uniqueInWords2.add(word);
            }
        }

        List<Set<String>> result = new ArrayList<>();
        result.add(uniqueInWords1);
        result.add(uniqueInWords2);

        return result;
    }
}
