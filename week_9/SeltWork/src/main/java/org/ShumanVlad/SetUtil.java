package org.ShumanVlad;

import java.util.Set;
import java.util.HashSet;

/**
 This SetUtil class tests various usages of the Set class.
 param1 is a string. You will create a set with all vowels, a,e,i,o,u. Then you will return
 string with all vowels removed. Vowels may be lower or upper case.
 */
public class SetUtil
{

    public static String check(String str)
    {
        // TODO Create a stack of Character elements, caled stack,  with all possible vowels

        return processSet(stack, str);
    }


    public static String processSet(Set<Character> set, String str)
    {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++)
        {
            // TODO: if a string char is in the set do nothing, otherwise append it
            // to the stringbuffer, sb
        }

        return sb.toString();
    }
}