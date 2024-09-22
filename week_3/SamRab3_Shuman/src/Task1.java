/*
Задача 1
Дано два числа, например, 3 и 56, необходимо составить следующие строки:
3 + 56 = 59
3 – 56 = -53
3 * 56 = 168
 */

public class Task1
{
    public static String plus(int a, int b)
    {
        return String.format(a + " + " + b + " = " + (a+b));
    }
    public static String minus(int a, int b)
    {
        return Integer.toString(a) +
                " - " +
                Integer.toString(b) +
                " = " +
                Integer.toString(a - b);
    }

    public static String multiply(int a, int b)
    {
        return String.format(a + " * " + b + " = " + (a*b));
    }
}
