import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {

    public static void ans() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Task15 : ");
        int n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> triangle = generatePascalsTriangle(n);

        for (int i = 0; i < triangle.size(); ++i)
        {
            System.out.println(triangle.get(i));
        }
    }

    public static ArrayList<ArrayList<Integer>> generatePascalsTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> currentRow = new ArrayList<Integer>();
            currentRow.add(1);
            ArrayList<Integer> previousRow = triangle.get(i - 1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            triangle.add(currentRow);
        }

        return triangle;
    }
}
