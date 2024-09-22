package org.lab;

public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
    public static MyException FileNotExist(String fileName){return new MyException("no file with name " + fileName);}
    public static MyException InvalidColums(int colums, int real){return new MyException("invalid colums, cols = " + colums + ", but real = " +real);}
    public static MyException InvalidNumber(int i, int j) {return new MyException("is not number on (" + i + " , "+ j + ")");}
    public static MyException InvalidRows(int rows){return new MyException("invalid rows, rows = " + rows + ", but you have less or more");}
    public static MyException InvalidAmountArguments(){return new MyException("invalid amount of arguments (rows,cols). !=2");}
    public static MyException InvalidRowsCols_notNumber(){return new MyException("invalid rows or cols : not number");}
    public static MyException InvalidRowsCols_lessZero(){return new MyException("invalid rows or cols : less zero");}
    public static MyException InvalidConsoleArguments(){return new MyException("invalid console argument (!=1)");}
}

/*
нет файла
плохие аргументы
 */