public class Task2
{
    public static int amountWordsLatin(String string)
    {
        String[] words = string.split("\\s+");
        int count = 0;
        for (String word: words)
        {
            if (isWordCorrect(word))
            {
                count++;
            }
        }
        return count;
    }

    private static boolean isWordCorrect(String word)
    {
        return word.matches("[a-zA-Z]+");
    }
}