public class MyException extends Exception
{
    public static Exception NoInteger(String noNumber)
    {
        return new Exception("it is not integer : " + noNumber);
    }

}
