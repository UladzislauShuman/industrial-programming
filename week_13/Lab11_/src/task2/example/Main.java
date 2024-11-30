package task2.example;
/*
    1) Реализовать возможность добавления данных в диалоговом окне.
Реализовать команду Файл–Открыть. При открытии данные отображаются в одной компоненте, при обработке данных – в другой.

12. Дан файл, содержащий сведения об игрушках: название, стоимость и возрастные границы детей, для которых игрушка предназначена.
Построить различные списки игрушек для заданного возраста,
суммарная стоимость которых не превосходит заданную величину.
 */

import org.example.toys.Toys;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Toys toys = new Toys("input_10.txt");
            System.out.println(toys.toString());
            System.out.println("-\n");
            System.out.println(toys.getToysForThisAge(5).sortByPrice(20).toString());
            System.out.println("res\n");
            String lists = toys.toStringLists(5, 20);
            System.out.println(lists);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}