package org.example;/*
Входные данные задаются как параметры командной строки.
Показать генерацию и обработку исключительной ситуации
собственного класса.
При работе со строками использовать классы StringBuffer или
StringBuilder. Если нужно разбивать строку на элементы,
использовать класс StringTokenizer либо использовать метод
класса String.
Продемонстрировать работу данного проекта без среды, т.е.
осуществть запуск через командную строку.

Строка представляет собой бесскобочное арифметическое
выражение, состоящее из переменной X, целых констант, +, -.
Вычислить значение выражения при заданном X. (Стек не
использовать).

StringTokenizer -- поработать с третьим параметром
 */

public class ExpressionOfX
{
    public static int countEquation(String equation, int x)
    {
        try
        {
            //для примера 2 + x + 6 - 5 - x
            //String[] tokens = equation.split(" ");
            String[] tokens = breakLine(equation);
            int ans = 0;
            boolean isPlus = true;
            boolean isSign = false;
            for (int i = 0; i < tokens.length; ++i)
            {
                switch (tokens[i])
                {
                    case "+":
                        if (isSign == true)
                        {
                            isPlus = (isPlus == true);
                        }
                        else
                        {
                            isSign = true;
                            isPlus = true;
                        }
                        break;
                    case "-":
                        if (isSign == true)
                        {
                            isPlus = (isPlus == false);
                        }
                        else
                        {
                            isSign = true;
                            isPlus = false;
                        }
                        break;

                    case "x":
                        if (isPlus)
                            ans += x;
                        else
                            ans -= x;
                        isSign = false;
                        break;
                    default:
                        if (!tokens[i].matches("\\d+"))
                            throw MyException.NoInteger(tokens[i]);
                        if (tokens[i] != "+" & tokens[i] != "-" & !tokens[i].matches("\\d+"))
                            throw  MyException.NoPlusMinus(tokens[i]);

                        if (isPlus)
                            ans += Integer.parseInt(tokens[i]);
                        else
                            ans -= Integer.parseInt(tokens[i]);
                        isSign = false;
                        break;
                }
                System.out.println(tokens[i]);
            }
            return ans;
        }
        catch (Exception e)
        {
            System.err.println("ошибка\n" + e.getMessage());
            return 0;
        }
    }

    public static int countEquation(String equation, String x)
    {
        try
        {
            if (x.matches("\\d+"))
                throw MyException.NoInteger(x);
            return countEquation(equation, Integer.parseInt(x));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    private static String[] breakLine(String line)
    {
        return line.replaceAll(" ", "").split("(?<=[-+ ])|(?=[-+ ])");
    }
}
