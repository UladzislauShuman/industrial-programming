import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Scanner scan = new Scanner(System.in); // (new File("1.txt"));
            System.out.println("locale ="+ Locale.getDefault());
            System.out.println("locale =" + scan.locale());
            scan.useLocale(Locale.US);
            System.out.println("l|ocale ="+ scan.locale());
            int n = scan.nextInt();
            scan.useDelimiter("[,\\s]+");
            System.out.println("delimiter= "+ scan.delimiter());
            double[][] matr = new double[n][n];
            for (int i=0; i<n; ++i)
            {
                for (int j=0; j<n; ++j)
                    matr[i][j]= scan.nextDouble();
            }
            System.out.println(Arrays.deepToString(matr));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}