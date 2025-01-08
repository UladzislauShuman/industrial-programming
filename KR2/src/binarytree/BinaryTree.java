package binarytree;

import iterator.BinaryTreeIterator;
import strategy.MaxFindingStrategy;
import strategy.RecursiveMaxStrategy;
import strategy.StreamMaxStrategy;
import visitor.VisitorInterface;
import visitor.VisitorableInterface;

import java.io.*;
import java.util.*;

public class BinaryTree implements VisitorableInterface<BinaryTree> {
    private final List<Integer> tree;
    private MaxFindingStrategy maxFindingStrategy = new StreamMaxStrategy();
    public BinaryTree() {
        tree = new ArrayList<>();
        tree.add(0);
    }

    public void add(int value) {
        if (tree.get(0) == 0) {
            tree.set(0, value);
            ensureCapacity(3);
            tree.set(1, 0);
            tree.set(2, 0);
            return;
        }
        addRecursive(0, value);
    }

    private void addRecursive(int index, int value) {
        ensureCapacity(2 * index + 3);
        if (tree.get(index) == 0) {
            tree.set(index, value);
            tree.set(2 * index + 1, 0);
            tree.set(2 * index + 2, 0);
        } else if (value < tree.get(index)) {
            addRecursive(2 * index + 1, value);
        } else {
            addRecursive(2 * index + 2, value);
        }
    }

    private void ensureCapacity(int minCapacity) {
        while (tree.size() < minCapacity) {
            tree.add(0);
        }
    }

    public void setMaxFindingStrategy(MaxFindingStrategy strategy)
    {
        this.maxFindingStrategy = strategy;
    }

    public int max() {
        return this.maxFindingStrategy.findMax(this);
    }

    public List<Integer> moveToMax() {
        int maxValue = max();
        List<Integer> path = new ArrayList<>();
        moveToMaxHelper(0, maxValue, path);
        return path;
    }

    private boolean moveToMaxHelper(int index, int target, List<Integer> path) {
        if (index >= tree.size() || tree.get(index) == 0) {
            return false;
        }
        path.add(tree.get(index));
        if (tree.get(index) == target) {
            return true;
        }
        if (moveToMaxHelper(2 * index + 1, target, path) || moveToMaxHelper(2 * index + 2, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public void preOrderTraversal(int index, List<Integer> result) {
        if (index >= tree.size() || tree.get(index) == 0) {
            return;
        }
        result.add(tree.get(index));
        preOrderTraversal(2 * index + 1, result);
        preOrderTraversal(2 * index + 2, result);
    }

    public void open(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                for (String value : values) {
                    try {
                        add(Integer.parseInt(value));
                    } catch (NumberFormatException e) {
                        //
                    }
                }
            }
        }
    }

    public List<Integer> getTreeList() {
        return tree;
    }

    public BinaryTreeIterator createIterator() {return new BinaryTreeIterator(this);}

    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();
//        tree.add(8);
//        tree.add(3);
//        tree.add(10);
//        tree.add(1);
//        tree.add(6);
//        tree.add(14);
//        tree.add(4);
//        tree.add(7);
//        tree.add(13);

        tree.open("input.txt");
        System.out.println("\nTest BinaryTreeIterator:");
        BinaryTreeIterator iterator = tree.createIterator();
        List<Integer> iteratorResult = new ArrayList<>();
        while (!iterator.isDone()) {
            iteratorResult.add(iterator.getCurrentItem());
            iterator.next();
        }
        System.out.println("Iterator traversal: " + iteratorResult);

        tree.setMaxFindingStrategy(new RecursiveMaxStrategy());
        System.out.println("Max (Recursive): " + tree.max());
    }

    @Override
    public void accept(VisitorInterface<BinaryTree> visitor) {
        visitor.visit(this);
    }

    public void clearAll()
    {
        this.tree.clear();
    }
    public void addAll(BinaryTree tree)
    {
        this.tree.addAll(tree.tree);
    }

    @Override
    public String toString()
    {
        StringBuilder sb =new StringBuilder();
        BinaryTreeIterator iterator = new BinaryTreeIterator(this);
        for(iterator.first();!iterator.isDone();iterator.next())
            sb.append(iterator.getCurrentItem()).append(" ");

        return sb.toString();
    }


}
