package org.example;

public class MyException extends Exception
{
    public static Exception NoInteger(String noNumber) {return new Exception("it is not integer : " + noNumber);}
    public static Exception NoPlusMinus(String noPlusMinus) { return new Exception("it is not plus or minus : " + noPlusMinus);}
}
