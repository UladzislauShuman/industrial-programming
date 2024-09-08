import java.io.IOException;
//(-1)^n*1^(n + 2)/(((n + 1)*factorial(n + 2)))

public class Main {
    public static void main(String[] args) throws IOException
    {
        try
        {
            if (args.length != 2) {
                throw new IOException("Invalid console arguments");
            }
            double x = 0.5;
            x = Double.parseDouble(args[0]);
            double precession = 0.1;
            precession = Double.parseDouble(args[1]);
            double sum = 0;
            calculate(x, precession);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static double calculate(double x, double precession)
    {
        double current = Math.pow(-1, 1) * Math.pow(x, 1 + 2) / ((1 + 1) * (1 + 2) * (1 + 1));
        double sum = 0;
        int k = 1;
        while (Math.abs(current) > precession) {
            sum += current;
            System.out.println("k = " + k);
            System.out.println("Sum: " + sum);
            System.out.println("Last element: " + current + "---");
            current = currentCalculate(current,x,k) ;
            k++;
        }
        return sum;
    }

    private static double currentCalculate(double current, double x, int k)
    {
        return current * x * (-1) * (k + 1) / ((k + 2)*(k + 3));
    }
}

