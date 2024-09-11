package org.example;

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
            System.out.println(ExpressionOfX.countEquation("-24 - x + 25", 12));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}