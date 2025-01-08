package strategy;

import binarytree.BinaryTree;

import java.util.List;

public class RecursiveMaxStrategy implements MaxFindingStrategy {
    @Override
    public int findMax(BinaryTree tree) {
        return findMaxRecursive(tree, 0);
    }

    private int findMaxRecursive(BinaryTree tree, int index) {
        List<Integer> treeList = tree.getTreeList();
        if (index >= treeList.size() || treeList.get(index) == 0) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMaxRecursive(tree, 2 * index + 1);
        int rightMax = findMaxRecursive(tree, 2 * index + 2);
        return Math.max(treeList.get(index), Math.max(leftMax, rightMax));

    }
}