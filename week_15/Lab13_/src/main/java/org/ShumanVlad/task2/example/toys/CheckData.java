package org.ShumanVlad.task2.example.toys;

public class CheckData
{
    public static void checkToyData(String name, int price, int fromAge, int toAge) throws Exception
    {
        if (name.isEmpty())
            throw new Exception("No name");
        if (price < 0)
            throw new Exception("price < 0");
        if (fromAge < 0)
            throw new Exception("fromAge < 0");
        if (toAge < 0)
            throw new Exception("toAge < 0");
        if (fromAge > toAge)
            throw new Exception("fromAge > toAge");
    }

    public static void checkToysData(String fileName) throws Exception
    {
        if (fileName.isEmpty())
            throw new Exception("Empty file name");
        if (!fileName.endsWith(".txt"))
            throw new Exception(fileName + " is not txt");
    }
}
