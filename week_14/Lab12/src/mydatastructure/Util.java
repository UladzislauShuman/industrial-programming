package mydatastructure;

public class Util
{
    public static int nextPrime(int n)
    {
        while (true)
        {
            if (isPrime(n))
                return n;
            n++;
        }
    }


    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (isDivisibleBy2Or3(n)) return false;
        return !isDivisibleBy6kPlusMinus1(n);
    }

    private static boolean isDivisibleBy2Or3(int n) {
        return n % 2 == 0 || n % 3 == 0;
    }

    private static boolean isDivisibleBy6kPlusMinus1(int n) {
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return true;
            }
        }
        return false;
    }



}
