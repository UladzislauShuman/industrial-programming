package org.lab;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
    public static MyException GetDataFromNull(){return new MyException("Get Data From Null");}
    public static MyException NullValueInArgument(){return new MyException("Null Value in argument");}
}
