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
    //чёт пока не может найтись автоматически нужный класс
    //появится в финальной версии до следующего понедельника
    public static <T> T getSum(T[] array) throws Exception
    {
        if (array.length == 0)
        {
            throw new Exception("array.length == 0");
        }
        //надо чтобы был равено внутреннему нейтральному элементу
        T res;
        for (T e : array)
        {
            res += e;
        }
        return res;
    }

    //6
    //такае же ситуация как и с 5)
    public static <T> T getMedium(T[] array) throws Exception
    {
        if (array.length == 0)
        {
            throw new Exception("array.length == 0");
        }
        return getSum(array) / array.length;
    }

    //7
    //пока не придумал

    public static void main(String[] args)
    {
        return;
    }
}