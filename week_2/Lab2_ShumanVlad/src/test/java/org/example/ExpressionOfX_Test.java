package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionOfX_Test {

    @Test
    void countEquation()
    {
        Assertions.assertEquals(19,ExpressionOfX.countEquation("12+x - 6", 13));
        Assertions.assertEquals(-11,ExpressionOfX.countEquation("-24 - x + 25", 12));
        Assertions.assertEquals(13,ExpressionOfX.countEquation("x + 6 - 6", 13));

        Assertions.assertTrue(19 == ExpressionOfX.countEquation("12+x - 6", 13), "12+x - 6");
        Assertions.assertTrue(19 == ExpressionOfX.countEquation("12+x --- 6", 13), "12+x --- 6");
        Assertions.assertTrue(19 == ExpressionOfX.countEquation("12+x - - -6", 13), "12+x - - -6");
        Assertions.assertTrue(19 == ExpressionOfX.countEquation("12++++x - 6", 13), "12++++x - 6");
        Assertions.assertTrue(19 == ExpressionOfX.countEquation("12+-+-x - 6", 13), "12+-+-x - 6");
        Assertions.assertTrue(19 == ExpressionOfX.countEquation("--12+++x --- 6", 13), "--12+++x --- 6");
    }
}