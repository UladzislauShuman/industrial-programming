package org.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void NLR_LNR_LNR()
    {
        BinaryTree<Integer> tree = new BinaryTree<Integer>((Comparator<Integer>) Comparator.naturalOrder());
        int test = 5;
        tree.add(test);
        for (int i = 1; i < test; ++i)
        {
            tree.add(i);
        }
        for (int i = 6; i <= 10; ++i)
        {
            tree.add(i);
        }

        Assertions.assertEquals("5 1 2 3 4 6 7 8 9 10 ",
                tree.NLR()
        );
        Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10 ",
                tree.LNR()
        );
        Assertions.assertEquals("4 3 2 1 10 9 8 7 6 5 ",
                tree.LRN()
        );
    }

    @Test
    void delete()
    {
        //для этого теста мне нужно сделать дерево немного другой формы
        BinaryTree<Integer> tree = new BinaryTree<Integer>(9);
        tree.add(6); tree.add(3); tree.add(1); tree.add(2); tree.add(4);tree.add(5);
        tree.add(8);tree.add(7);
        tree.add(17); tree.add(16);tree.add(20);tree.add(12);tree.add(19);tree.add(21);tree.add(18);
        tree.add(11); tree.add(10); tree.add(14); tree.add(13);tree.add(15);

        Assertions.assertEquals(tree.delete(4), true);
        Assertions.assertEquals("1 2 3 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 ",
                tree.LNR()
        );
        Assertions.assertEquals(tree.delete(12), true);
        Assertions.assertEquals("1 2 3 5 6 7 8 9 10 11 13 14 15 16 17 18 19 20 21 ",
                tree.LNR()
        );
        Assertions.assertEquals(tree.delete(9), true);
        Assertions.assertEquals("1 2 3 5 6 7 8 10 11 13 14 15 16 17 18 19 20 21 ",
                tree.LNR()
        );
        Assertions.assertEquals(tree.delete(5), true);
        Assertions.assertEquals("1 2 3 6 7 8 10 11 13 14 15 16 17 18 19 20 21 ",
                tree.LNR()
        );

    }
}