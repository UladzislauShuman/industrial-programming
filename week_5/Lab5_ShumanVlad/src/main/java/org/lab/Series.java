package org.lab;
//
//Создать абстрактный класс Series (прогрессия) с методами:
//        • вычисления j-го элемента прогрессии (абстрактный);
//    • вычисления суммы прогрессии (не абстрактный);
//    • toString, возвращает строку с элементами прогрессии (не абстрактный);
//    • сохранения прогрессии в файл (не абстрактный);

import java.io.File;
import java.io.FileWriter;

public abstract class Series
{
    private double a;
    private double d;

    public double getA()
    {
        return this.a;
    }

    public double getD()
    {
        return this.d;
    }

    public Series(double a, double d)
    {
        this.a = a;
        this.d = d;
    }

    public abstract double getElement(int n);

    public double getSum(int start, int end)
    {
        double sum = 0.0;
        for (int i = start; i <= end; ++i)
        {
            sum += this.getElement(i);
        }
        return sum;
    }

    public String toString(int start, int end)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= end; ++i)
        {
            sb.append(" ").append(this.getElement(i));
        }
        return sb.toString();
    }

    public void saveFile(String fileName, int n) throws Exception
    {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(this.toString(1, n));
        writer.close();
    }
}
