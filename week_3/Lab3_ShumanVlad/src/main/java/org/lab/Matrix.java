package org.lab;

import java.io.File;
import java.util.Scanner;

public class Matrix
{
    private int rows;
    private int cols;
    private int[][] matrix;

    public Matrix(String fileName) throws MyException
    {
        try
        {
            File file = new File(fileName);
            Scanner scanner;
            if (file.exists())
            {
                scanner = new Scanner(file);

                String[] rows_cols = scanner.nextLine().split(" ");
                if (rows_cols.length != 2)
                    throw MyException.InvalidAmountArguments();

                if (!rows_cols[0].matches("-?\\d+") || !rows_cols[1].matches("-?\\d+"))
                    throw MyException.InvalidRowsCols_notNumber();

                this.rows = Integer.parseInt(rows_cols[0]);
                this.cols = Integer.parseInt(rows_cols[1]);

                if (this.rows <= 0 || this.cols <= 0)
                    throw MyException.InvalidRowsCols_lessZero();

                this.matrix = new int[rows][cols];
                for (int i = 0; i < rows; ++i) {

                    if (!scanner.hasNextLine())
                        throw MyException.InvalidRows(this.rows);

                    String[] temp = scanner.nextLine().split(" ");

                    if (temp.length != cols)
                        throw MyException.InvalidColums(cols, temp.length);

                    for (int j = 0; j < cols; ++j) {

                        if (!temp[j].matches("-?\\d+"))
                            throw MyException.InvalidNumber(i, j);

                        this.matrix[i][j] = Integer.parseInt(temp[j]);
                    }
                }
                if(scanner.hasNextLine())
                    throw MyException.InvalidRows(this.rows);
            }
            else
            {
                throw MyException.FileNotExist(fileName);
            }


        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            throw new MyException(e.getMessage());
        }
    }

    public int[][] getMatrix()
    {
        return this.matrix;
    }

    public void printMatrix()
    {
        for (int i = 0; i < this.rows; ++i)
        {
            for (int j = 0;j < this.cols; ++j)
            {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public String printMinMax()
    {
        StringBuilder min = new StringBuilder("Min :");
        StringBuilder max = new StringBuilder("Max :");
        for (int i = 0; i < this.rows; ++i)
        {
            for (int j = 0; j < this.cols; ++j)
            {
                if(isLocalMin(i,j))
                    min.append(" " + this.matrix[i][j]);
                if(isLocalMax(i,j))
                    max.append(" " + this.matrix[i][j]);
            }
        }

        return min.toString() + "\n" + max.toString();
    }

    private boolean isLocalMin(int i, int j)
    {
        boolean ans = true;
        //если между верхом и низом краем
        if (i > 0 && i < this.rows - 1)
        {
            ans &= this.matrix[i][j] < this.matrix[i - 1][j] &&
                    this.matrix[i][j] < this.matrix[i + 1][j];
        }
        else
        {
            //если мы в верхнем краю И это не матрице n на 1
            if(i == 0 && i < this.rows - 1)
                ans &= this.matrix[i][j] < this.matrix[i + 1][j];
            //если мы в нижнем краю И это не матрице n на 1
            else
            {
                if ((i == this.rows - 1) && i > 0)
                    ans &= this.matrix[i][j] < this.matrix[i - 1][j];
            }
        }

        //если мы между левым и правым
        if (j > 0 && j < this.cols - 1)
        {
            ans &= this.matrix[i][j] < this.matrix[i][j + 1] &&
                    this.matrix[i][j] < this.matrix[i][j - 1];
        }
        else
        {
            //если мы в левом краю И это не матрице 1 на n
            if(j == 0 && this.cols > 1)
                ans &= this.matrix[i][j] < this.matrix[i][j + 1];
            //если мы в правом краю И это не матрице 1 на n
            else
            {
                if ((j == this.cols - 1) && j > 0)
                    ans &= this.matrix[i][j] < this.matrix[i][j - 1];
            }
        }

        return ans;
    }

    private boolean isLocalMax(int i, int j)
    {
        boolean ans = true;
        //если между верхом и низом краем
        if (i > 0 && i < this.rows - 1)
        {
            ans &= this.matrix[i][j] > this.matrix[i - 1][j] &&
                    this.matrix[i][j] > this.matrix[i + 1][j];
        }
        else
        {
            //если мы в верхнем краю И это не матрице n на 1
            if(i == 0 && i < this.rows - 1)
                ans &= this.matrix[i][j] > this.matrix[i + 1][j];
                //если мы в нижнем краю И это не матрице n на 1
            else
            {
                if ((i == this.cols - 1) && i > 0)
                    ans &= this.matrix[i][j] > this.matrix[i - 1][j];
            }
        }

        //если мы между левым и правым
        if (j > 0 && j < this.cols - 1)
        {
            ans &= this.matrix[i][j] > this.matrix[i][j + 1] &&
                    this.matrix[i][j] > this.matrix[i][j - 1];
        }
        else
        {
            //если мы в левом краю И это не матрице 1 на n
            if(j == 0 && this.cols > 1)
                ans &= this.matrix[i][j] > this.matrix[i][j + 1];
                //если мы в правом краю И это не матрице 1 на n
            else
            {
                if ((j == this.cols - 1) && j > 0)
                    ans &= this.matrix[i][j] > this.matrix[i][j - 1];
            }
        }

        return ans;
    }
}
