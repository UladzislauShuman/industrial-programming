package strategy;

import binarytree.BinaryTree;

import java.util.Comparator;

public class StreamMaxStrategy implements MaxFindingStrategy {
    @Override
    public int findMax(BinaryTree tree) {
        return tree.getTreeList().stream()
                .filter(val -> val != 0)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("Tree is empty"));
    }
}


