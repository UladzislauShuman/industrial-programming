package org.lab;

/*
Задание j5
Создать абстрактный класс Series (прогрессия) с методами:
    • вычисления j-го элемента прогрессии (абстрактный);
    • вычисления суммы прогрессии (не абстрактный);
    • toString, возвращает строку с элементами прогрессии (не абстрактный);
    • сохранения прогрессии в файл (не абстрактный);

Определить производные классы: Liner (арифметическая прогрессия)
и Exponential (геометрическая прогрессия). Реализовать вывод элементов
и суммы прогрессии в файл.

Реализовать оконное приложение с удобным интерфейсом (выбор прогрессии, выбор имени файла и т.п.),
в т.ч. отображения на окне первых n элементов.
 */

public class Main {
    public static void main(String[] args)
    {
        Liner liner = new Liner(1,1);
        System.out.println(liner.toString(1, 10));
        System.out.println(new Exponential(1, 2).toString(1, 10));
    }
}