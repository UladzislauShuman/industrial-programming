public class Figurs {
    public static void drawTriangle()
    {
        System.out.println("""
                   x
                  xxx
                 xxxxx
                xxxxxxx
                """);
    }
    public static void drawStaircase(int amount)
    {
        String staircases = "____\n";
        for (int stare = 1; stare <= amount;++stare)
        {
            staircases += "I" + "__" + "___".repeat(stare - 1) + "I" + "___\n";
        }
        System.out.println(staircases);
    }

    public static void drawParallelogram(int height, int width)
    {
        String parallelogram = " ".repeat(height) + "_".repeat(width) +"\n";
        for (int i = 1; i < height; ++i)
        {
            parallelogram += " ".repeat(height - i) + "/" + " ".repeat(width - 1) + "/" + "\n";
        }
        parallelogram += "/" + "_".repeat(width - 1) + "/" + "\n";
        System.out.println(parallelogram);
    }

    public static void drawTreeBrush()
    {
        System.out.println("""
                        o
                      oooo
                    ooooooo
                    oooooooo
                     ooIIo o       ooo
                     o II         oooooo
                  _____II_________ oooo____

                """);
    }

    public static void writeLastThreeLinesOfPoem()
    {
        System.out.println("""
                Two roads diverged in a wood, and I --
                I took the one less traveled by,
                And that has made all the difference.
                    by Robert Frost
                """);
    }

    public static void writePeterPiper()
    {
        System.out.println("""
                Peter Piper picked a peck of pickled peppers.
                A peck of pickled peppers, Peter Piper picked.
                If Peter picked a peck of pickled peppers,
                Where's the peck of pickled peppers Peter Piper picked?
                """);
    }

    public static void writeAlgebraText()
    {
        System.out.println(
                "Given: f(x) = 3x - 15\n" +
                "Let x = 4\n" +
                "Then\n" +
                "  f(4) = 3x4 - 15\n" +
                "       = 12 - 15\n" +
                "       = -3");
    }

    public static void drawMultiplicationTable()
    {
        System.out.println(
                "    y | 1y | 2y | 3y | 4y | 5y \n" +
                "  ----|----|----|----|----|----\n" +
                "    1 |  1 |  2 |  3 |  4 |  5\n" +
                "    2 |  2 |  4 |  6 |  8 | 10\n" +
                "    3 |  3 |  6 |  9 | 12 | 15\n" +
                "    4 |  4 |  8 | 12 | 16 | 20\n" +
                "    5 |  5 | 10 | 15 | 20 | 25\n" +
                "    6 |  6 | 12 | 18 | 24 | 30\n" +
                "    7 |  7 | 14 | 21 | 28 | 35\n" +
                "    8 |  8 | 16 | 24 | 32 | 40\n" +
                "    9 |  9 | 18 | 27 | 36 | 45\n" +
                "   10 | 10 | 20 | 30 | 40 | 50");
    }
}
