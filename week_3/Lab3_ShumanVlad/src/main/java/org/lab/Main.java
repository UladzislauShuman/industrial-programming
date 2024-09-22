package org.lab;

import java.io.File;
import java.util.Scanner;
import org.lab.Matrix;

public class Main {
    public static void main(String[] args)
    {
        try
        {
//            if (args.length != 1)
//                // добавить в свой класс исключений
//                throw new Exception("!=1");

            Matrix matrix = new Matrix("test.txt");
            matrix.printMatrix();
            System.out.println(matrix.printMinMax());



        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}