/*
Напишите программу, выбирающую и выводящую лотерейную комбинацию
из шести отдельных чисел в пределах от 1 до 49. Чтобы выбрать шесть отдель­
ных чисел, начните со списочного массива, заполняемого числами от 1 до 49.
Выберите произвольный индекс и удалите элемент массива. Повторите эти
действия шесть раз подряд. Выведите полученный результат в отсортирован
ном порядке.
 */

import java.util.ArrayList;
import java.util.Random;

public class Task13
{
    public static void ans()
    {
        //начните со списочного массива, заполняемого числами от 1 до 49.
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }

        Random random = new Random();
        ArrayList<Integer> ticket = new ArrayList<Integer>();

//        Повторите эти действия шесть раз подряд.
        for (int i = 0; i < 6; i++) {
            //Выберите произвольный индекс
            int randomIndex = random.nextInt(numbers.size());
            //и удалите элемент массива.
            ticket.add(numbers.remove(randomIndex));
        }

        //Выведите полученный результат в отсортированом порядке
        System.out.println(ticket.stream().sorted().toList().toString());
    }
}



