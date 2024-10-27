package org.conwrk_ex.tools;

public class Tools
{
    public static String deleteFirstWord(String line)
    {
        int indexOfFirstSpace = line.indexOf(" ");
        if (indexOfFirstSpace != -1) {
            line = line.substring(indexOfFirstSpace + 1);
        }
        return line;
    }
}
