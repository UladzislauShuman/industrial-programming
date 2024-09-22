package org.lab;

import java.io.File;
import java.util.Scanner;
import org.lab.Matrix;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 1)
                throw MyException.InvalidConsoleArguments();

            Matrix matrix = new Matrix(args[0]);
            matrix.printMatrix();
            System.out.println(matrix.printMinMax());



        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}