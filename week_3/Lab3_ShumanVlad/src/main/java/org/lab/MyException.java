package org.lab;

public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
    public static MyException FileNotExist(String fileName){return new MyException("no file with name " + fileName);}
    public static MyException InvalidColums(int colums, int real){return new MyException("invalid colums, cols = " + colums + ", but real = " +real);}
    public static MyException InvlaidNumber(int i, int j) {return new MyException("is not number on (" + i + " , "+ j + ")");}
    public static MyException InvalidRows(int rows){return new MyException("invalid rows, rows = " + rows + ", but you have more");}
}

/*
нет файла
плохие аргументы
 */