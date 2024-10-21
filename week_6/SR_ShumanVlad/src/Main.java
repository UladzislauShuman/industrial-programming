import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            File inputfile = new File("input.txt");
            File outputfile = new File("output.txt");
            Scanner scanner = new Scanner(inputfile);

            double[] ans = new double[10];

            int i = 0;
            double ans_ = 0.0;

            while (scanner.hasNextLine())
            {
               //String line = scanner.nextLine();
                String[] elements =  scanner.nextLine().split("[\\nа-яА-Я,;\\s]+");
                for (String element : elements)
                {
                    if(!element.isEmpty())
                        ans_ += Double.parseDouble(element);
                }
                System.out.println(ans_);
                System.out.println(Arrays.toString(elements));
            }
            System.out.println(Arrays.toString(ans));
            PrintWriter out = new PrintWriter(outputfile);
            out.println(ans_)z;
            out.close();
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
}


