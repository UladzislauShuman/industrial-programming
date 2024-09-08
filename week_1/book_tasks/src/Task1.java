import java.util.Scanner;

public class Task1 {
    public static void printNumber()
    {
        System.out.print("Task1, напиши своё число : ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.printf("двоичное : %s\n", Integer.toBinaryString(number));
        System.out.printf("восьмиричное : %o\n", number);
        System.out.printf("шестнадцатеричное : %x\n", number);
        System.out.printf("обратное значение в виде шестнадцатеричного числа с плавающей точкой : %s\n",
                            Float.toHexString(1.0f / number));
    }

}
