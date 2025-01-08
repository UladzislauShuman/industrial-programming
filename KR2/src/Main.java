import binarytree.BinaryTree;
import mvc.controller.Controller;
import mvc.view.View;

import java.io.Console;
import java.io.IOException;
//есть README.txt!!!
public class Main {
    public static void main(String[] args) throws IOException {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.open("input.txt");
        View view = new View(binaryTree);
        Controller controller = new Controller(binaryTree,view);

    }
}