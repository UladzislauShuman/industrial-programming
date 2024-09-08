public class Task4 {
    public static double min = Math.nextUp(Double.MIN_VALUE);
    public static double max = Math.nextDown(Double.MAX_VALUE);

    public static void minAndMaxDouble()
    {
        System.out.printf("min double : %f\n", min);
        System.out.printf("min double : %f\n", max);
    }
}
