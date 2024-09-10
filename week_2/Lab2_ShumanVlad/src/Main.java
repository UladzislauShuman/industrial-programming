
/*
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
            //System.err
            System.out.println(e.getMessage());
        }
    }
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        try
        {
//            if (args.length != 1){
//                throw new IOException("args.length != 1");
//            }
//            ExpressionOfX.countEquation(args[0], Double.parseDouble(args[1]));
            System.out.println(ExpressionOfX.countEquation("12.0+x - 6", 13));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}