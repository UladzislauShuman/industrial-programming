package org.conwrk_ex.tools;

import org.conwrk_ex.objects.exceptions.SweetException;
import org.conwrk_ex.objects.present.Present;
import org.conwrk_ex.objects.sweet.Sweet;

import java.io.*;

public class FileWorker
{
    public static Present readFile(String fileName) throws Exception
    {
        return readFile(new File(fileName));
    }

    public static Present readFile(File file) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Present present = new Present();
        while((line = reader.readLine()) != null)
        {
            present.add(readLine(line));
        }
        reader.close();
        return present;
    }
    private static Sweet readLine(String line) throws Exception
    {
        String sweetType = line.split(" ")[0];
        Sweet sweet = (Sweet) SweetChooser.getFunction(sweetType).apply(Tools.deleteFirstWord(line));
        if (sweet == null)
            throw new SweetException(SweetException.Message.NULL_SWEET);
        return sweet;
    }

    public static void writeFile(String data, String fileName) throws Exception
    {
        writeFile(data, new File(fileName));
    }
    public static void writeFile(String data, File file) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(data);
        writer.close();
    }

}
