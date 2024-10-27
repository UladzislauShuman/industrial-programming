package org.conwrk_ex;

import org.conwrk_ex.tools.FileWorker;
import org.conwrk_ex.ui.Window;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            System.out.println(
                    FileWorker.readFile("input.txt").toString()
            );
            System.out.println(
                    FileWorker.readFile("input.txt").getStatistics()
            );
            Window window = new Window();

        }
        catch (Exception e)
        {
            System.out.println("here");
            System.out.println(e.getMessage());
        }
    }
}