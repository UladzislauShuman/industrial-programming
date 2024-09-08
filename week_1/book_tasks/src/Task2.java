import java.util.Scanner;

public class Task2 {
    public static void normalizeAngle()
    {
        System.out.print("write your angle : ");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        System.out.printf("result : %d\n", normalizeAngle(angle));
        System.out.printf("result with floorMod : %d\n", normalizeAngleFloorMod(angle));
    }
    private static int normalizeAngle(int angle)
    {
        angle %= 360;
        return angle >= 0 ? angle : (angle + 360);
    }

    private static int normalizeAngleFloorMod(int angle)
    {
        return Math.floorMod(angle, 360);
    }
}
