import java.util.Scanner;

public class Task3 {
    public static int max()
    {
        int a,b,c;
        System.out.print("write 3 numbers : ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt(); b = scanner.nextInt(); c = scanner.nextInt();
        int max = max(a,b,c);
        System.out.printf("max = %d\n", max(a,b,c));
        System.out.printf("Math.max = %d\n", mathMax(a,b,c));
        return max;
    }

    private static int max(int a, int b, int c)
    {
        return a > c? a > b? a : b : c > b? c : b;
    }

    private static int mathMax(int a, int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }
}
