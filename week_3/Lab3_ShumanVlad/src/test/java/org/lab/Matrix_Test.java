package org.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix_Test {

    @Test
    void printMinMax()
    {
        try
        {
            Assertions.assertEquals(
                    "Min : 1\nMax :",
                    new Matrix("tests/test1.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 1\nMax :",
                    new Matrix("tests/test2.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 1\nMax :",
                    new Matrix("tests/test3.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 1\nMax :",
                    new Matrix("tests/test4.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 1\nMax :",
                    new Matrix("tests/test5.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 1 1 1 1\nMax :",
                    new Matrix("tests/test6.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min :\nMax :",
                    new Matrix("tests/test7.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 2 5 7\nMax : 11 10 8 9",
                    new Matrix("tests/test8.txt").printMinMax()
            );
            Assertions.assertEquals(
                    "Min : 2 7\nMax : 11 10 8 9",
                    new Matrix("tests/test9.txt").printMinMax()
            );
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void Matrix_assertThrows()
    {

        Assertions.assertEquals(
                "no file with name tests_assertThrows/fileNotExist.txt",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/fileNotExist.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid rows, rows = 2, but you have less or more",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidRows_more.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid rows, rows = 2, but you have less or more",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidRows_less.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid colums, cols = 2, but real = 3",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidColums.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "is not number on (0 , 1)",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidNumber.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid amount of arguments (rows,cols). !=2",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidAmountArguments.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid rows or cols : not number",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidRowsCols_notNumber.txt");}
                ).getMessage()
        );

        Assertions.assertEquals(
                "invalid rows or cols : less zero",
                Assertions.assertThrows(
                        MyException.class,
                        () -> {new Matrix("tests_assertThrows/test_InvalidRowsCols_lessZero.txt");}
                ).getMessage()
        );
    }
}