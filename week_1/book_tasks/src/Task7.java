import java.util.Scanner;

public class Task7 {
    private final static int STEP = 32768;

    public static void keepShort()
    {
        System.out.printf("введите два числа в пределах от 0 до 65535 : ");
        Scanner scanner = new Scanner(System.in);
        short a = (short) (scanner.nextInt() - STEP);
        short b = (short) (scanner.nextInt() - STEP);
        System.out.printf("a + b = %d\n", (a + b + 2 * STEP));
        System.out.printf("a - b = %d\n", (a - b));
        System.out.printf("a * b = %d\n", (a + STEP) * (b + STEP));
        System.out.printf("a / b = %d\n", (a + STEP) / (b + STEP));
        System.out.printf("остаток = %d\n", (a + STEP) % (b + STEP));
    }
}
