package visitor;

import binarytree.BinaryTree;

import java.io.IOException;

public class TreeSumVisitor implements VisitorInterface<BinaryTree> {
    private int sum = 0;

    @Override
    public void visit(BinaryTree tree) {
        for (Integer value : tree.getTreeList()) {
            if (value != 0) {
                sum += value;
            }
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();
        tree.open("input.txt");

        TreeSumVisitor sumVisitor = new TreeSumVisitor();
        tree.accept(sumVisitor);
        System.out.println("Sum of nodes: " + sumVisitor.getSum());
    }
}

