package iterator;

import binarytree.BinaryTree;

import java.util.List;
import java.util.Stack;

public class BinaryTreeIterator implements IteratorInterface<Integer> {

    private final BinaryTree tree;
    private Stack<Integer> stack;
    private Integer currentItem;


    public BinaryTreeIterator(BinaryTree tree) {
        this.tree = tree;
        stack = new Stack<>();
        first();
    }

    @Override
    public void first() {
        stack.clear();
        if (this.tree.getTreeList().size() > 1) {
            stack.push(0);
        }
        next();
    }

    @Override
    public void next() {
        if (stack.isEmpty()) {
            currentItem = null;
            return;
        }

        int currentIndex = stack.pop();
        List<Integer> treeList = tree.getTreeList();
        if (currentIndex >= treeList.size() || treeList.get(currentIndex) == 0) {
            next();
            return;
        }

        currentItem = treeList.get(currentIndex);

        int rightChildIndex = 2 * currentIndex + 2;
        int leftChildIndex = 2 * currentIndex + 1;

        if (rightChildIndex < treeList.size() && treeList.get(rightChildIndex) != 0) {
            stack.push(rightChildIndex);
        }
        if (leftChildIndex < treeList.size() && treeList.get(leftChildIndex) != 0) {
            stack.push(leftChildIndex);
        }
    }

    @Override
    public boolean isDone() {
        return currentItem == null;
    }

    @Override
    public Integer getCurrentItem() {
        return currentItem;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);


        BinaryTreeIterator iterator = new BinaryTreeIterator(tree);
        while (!iterator.isDone()) {
            System.out.print(iterator.getCurrentItem() + " ");
            iterator.next();
        }
    }
}

