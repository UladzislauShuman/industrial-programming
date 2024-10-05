import java.util.function.Predicate;

public class Main {
    //1
    //Equatable или Comparable
    public static <T> boolean find(T[] array, T value)
    {
        for (T element : array)
        {
            if (element.equals(value))
                return true;
        }
        return false;
    }

    //2
    public static <T> int getAmountEquals(T[] array, T value)
    {
        int count = 0;
        for (T element : array)
        {
            if (element.equals(value))
            {
                count++;
            }
        }
        return count;
    }

    //4
    public static <T extends Comparable<T>> int getAmountBigger(T[] array, T value)
    {
        int count = 0;
        for (T element : array)
        {
            int compare = element.compareTo(value);
            if (compare > 0)
                count++;
        }
        return count;
    }

    //5
    public static <T extends Number> double getSum(T[] array) throws Exception
    {
        if (array.length == 0)
        {
            throw new Exception("array.length == 0");
        }
        double res = 0;
        for (T e : array)
        {
            res += e.doubleValue();
        }
        return res;
    }

    //6
    public static <T extends Number> double getMedium(T[] array) throws Exception
    {
        if (array.length == 0)
        {
            throw new Exception("array.length == 0");
        }
        return getSum(array) / array.length;
    }

    //7
    public static <T> int getAmountPredicate(T[] array, Predicate<T> predicate)
    {
        int count = 0;
        for (T element : array)
        {
            if(predicate.test(element))
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        try
        {
            Integer[] array = {1,2,3,4,5,6,7,8,9,10};
            Predicate<Integer> predicate = element -> element % 2 == 0;

            System.out.println(Main.find(array, 2));
            System.out.println(Main.getAmountEquals(array, 11));
            System.out.println(Main.getAmountBigger(array, 4));
            System.out.println(Main.getSum(array));
            System.out.println(Main.getMedium(array));
            System.out.println(Main.getAmountPredicate(array, predicate));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}