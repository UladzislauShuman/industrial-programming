/*
Строка состоит из слов, разделенных пробелом, запятой или точкой.
Удалить из строки все слова,
которые являются целыми числами (состоят только из цифр).
 */

public class Task3
{
    public static String deleteUnnecessary(String text)
    {
        String[] words = text.split("\\s*[,.\\s]+\\s*");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.matches("\\d+")) {
                result.append(word).append(" ");
            }
        }

        return result.toString();
    }
}

