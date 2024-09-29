package org.lab;

public class Main {
    public static void main(String[] args)
    {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
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
//        tree.NLR();
        tree.LNR();
//        tree.LRN();
        tree.delete(5);
        tree.LNR();
        tree.add(5);
        tree.LNR();

    }
}