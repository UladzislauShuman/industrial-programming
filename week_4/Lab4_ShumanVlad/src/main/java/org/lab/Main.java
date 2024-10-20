package org.lab;

import java.util.Comparator;

public class Main {
    public static void main(String[] args)
    {
        BinaryTree<Integer> tree = new BinaryTree<Integer>((Comparator<Integer>)Comparator.naturalOrder());
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
        System.out.println(tree.NLR());
        System.out.println(tree.LNR());
        System.out.println(tree.LRN());
        System.out.println();
        tree.delete(5);
        System.out.println(tree.LNR());
        tree.add(5);
        tree.LNR();

    }
}