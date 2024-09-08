import java.math.BigInteger;

public class Task6 {
    public static BigInteger factorialBigInteger(int number)
    {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i)); // Умножение на i
        }
        System.out.println("Факториал " + number + "! = " + factorial);
        return factorial;
    }
}
