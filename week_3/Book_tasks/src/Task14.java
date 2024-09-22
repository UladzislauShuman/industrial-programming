/*
Напишите программу, вводящую двумерный массив целочисленных значений
и определяющую, содержится ли в нем магический квадрат (т.е. одинаковая
сумма значений во всех строках, столбцах и диагоналях). Принимая строки
вводимых данных, разбивайте их на отдельные целочисленные значения, прeкратив
этот процесс, когда пользователь введет пустую строку. Например, на
следующие вводимые данные:
16 3 2 13
3 10 11 8
9 6 7 12
4 15 14 1
(Пустая строка)
программа должна ответить утвердительно
 */

import java.util.Scanner;

public class Task14
{
    public static void ans()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task14:");

        int[][] matrix = read(scanner);

        if (isMagicSquare(matrix)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    ////
    private static int[][] read(Scanner scanner) {
        int size = 0;
        String line;
        while (!((line = scanner.nextLine()).isEmpty())) {
            size++;
        }
        scanner.reset();
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; ++row)
        {
            String[] numbers = scanner.nextLine().split(" ");
            System.out.println(numbers.toString());
            for (int col = 0; col < size; col++) {
                if (!numbers[col].isEmpty())
                    matrix[row][col] = Integer.parseInt(numbers[col]);
            }
            row++;
        }
        return matrix;
    }

    private static boolean isMagicSquare(int[][] matrix) {
        int sum = 0;
        for (int number : matrix[0]) {
            sum += number;
        }

        //строки
        for (int i = 1; i < matrix.length; i++) {
            int row = 0;
            for (int number : matrix[i]) {
                row += number;
            }

            if (row != sum) {
                return false;
            }
        }

        //столбцы
        for (int j = 0; j < matrix.length; j++) {
            int column = 0;
            for (int i = 0; i < matrix.length; i++) {
                column += matrix[i][j];
            }
            if (column != sum) {
                return false;
            }
        }

        // диагонали
        // главная
        int mainDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            mainDiagonal += matrix[i][i];
        }
        if (mainDiagonal != sum) {
            return false;
        }

        // побочная
        int reverseDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            reverseDiagonal += matrix[i][matrix.length - i - 1];
        }
        return reverseDiagonal == sum;
    }
}
