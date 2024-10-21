package org.lab;

import java.util.Comparator;

public class Main {
    public static void main(String[] args)
    {
        /*
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
        */
        try
        {

            Comparator<String> comparator1 = (Comparator<String>) Comparator.naturalOrder();
            Comparator<String> comparator2 = (String str1, String str2) -> {
                return str1.length() - str2.length();
            };
            Comparator<String> comparator3 = (s1,s2) -> s1.length() - s2.length();
            Comparator<String> comparator4 = Comparator.comparingInt(String::length);

            BinaryTree<String> binaryTree = new BinaryTree<>(comparator1);
            binaryTree.add("Petr");
            binaryTree.add("Ivan");
            binaryTree.add("Ann");
            binaryTree.add("Andrey");
            binaryTree.add("Pasha");
            System.out.println(binaryTree.LNR());

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}