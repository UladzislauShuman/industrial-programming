package org.lab;
/*
При сдаче задания иметь при себе тесты в виде соответствующих картинок.

Задание. Разработать пользовательский тип данных «Двоичное дерево поиска». Требуемые методы:
    • добавление вершины;
    • удаление вершины (опционально);
    • поиск вершины;
    • обход дерева «Вершина-Левый-Правый»;
    • обход дерева «Левый-Правый- Вершина»;
    • обход дерева «Левый- Вершина -Правый».
Использовать связную структуру для реализации двоичного дерева.

Параметризовать класс. Показать варианты
параметризации числом (Number)
и пользовательским классом (они реализуют интерфейс Comparable).

Читать:
    1 Классы;
    2 Параметризация классов.
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<T> implements BinaryTreeComparator<T>, Iterable<T>
{
    @Override
    public int compare(T object1, T object2) {
        return this.comparator.compare(object1, object2);
    }

    @Override
    /*
    тк мы не умеем/не представляем как
    итерировать дерево(любую другую кривую структуру данных)
    то просто сделаем то, что мы уже умеем итерировать
    Список
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private List<T> list = takeLeftRootRight();
            private int position = 0;
            @Override
            public boolean hasNext() {
                return position < list.size();
            }
            @Override
            public T next() {
                return list.get(position++);
            }
        };
    }

    public class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public T getData() throws MyException
        {
            if(this == null)
                throw MyException.GetDataFromNull();
            return this.data;
        }
    }

    private Comparator<T> comparator;
    private Node root;

    /*
    //конструктор с параметрами
    public BinaryTree(T value) throws MyException
    {
        if (value == null)
            throw MyException.NullValueInArgument();
        this.root = new Node(value);
    }
    */
    public BinaryTree(Comparator<T> comparator)  throws Exception
    {
        this.comparator = comparator;
        this.root = null;
    }

    //поиск вершины
    public Node find(T value) throws MyException
    {
        if (value == null)
            throw MyException.NullValueInArgument();
        return this.find(value, this.root);
    }

    private Node find(T value, Node current)
    {
        if (current != null)
        {
            int compare = this.comparator.compare(value, current.data);
            //int compare = value.compareTo(current.data);
            if (compare == 0)
                return current;
            else if(compare < 0)
                return this.find(value, current.left);
            else
                return this.find(value, current.right);
        }
        return null;
    }

//    • добавление вершины;
    /*
    я решил не добавлять элемент, который уже есть в дереве
     */
    public boolean add(T value) throws MyException
    {
        if (value == null)
            throw MyException.NullValueInArgument();
        if (this.root == null)
        {
            this.root = new Node(value);
            return true;
        }
        Node current = this.root;
        return this.add(value, this.root);
    }

    private boolean add(T value, Node current)
    {
        int compare = this.comparator.compare(value, current.data);
        if(compare < 0)
        {
            if (current.left == null) {
                current.left = new Node(value);
            }
            else {
                return this.add(value, current.left);
            }
        } else if (compare > 0) {
            if (current.right == null) {
                current.right = new Node(value);
            }
            else {
                return this.add(value, current.right);
            }
        }
        else {
            System.out.println("value has already here");
        }
        return true;
    }
    //    • обход дерева «Вершина-Левый-Правый»
    public String NLR()
    {
        StringBuilder ans = new StringBuilder();
        this.NLR(this.root, ans);
        System.out.println();
        return ans.toString();
    }
    private void NLR(Node local, StringBuilder sb)
    {
        if (local != null)
        {
            sb.append(local.getData() + " ");
            System.out.print(local.getData() + " ");
            this.NLR(local.left, sb);
            this.NLR(local.right, sb);
        }
    }
    //    • обход дерева «Левый-Правый- Вершина»;
    public String LRN()
    {
        StringBuilder ans = new StringBuilder();
        this.LRN(this.root, ans);
        System.out.println();
        return ans.toString();
    }
    private void LRN(Node local, StringBuilder sb)
    {
        if (local != null)
        {
            this.LRN(local.left, sb);
            this.LRN(local.right, sb);
            sb.append(local.getData() + " ");
            System.out.print(local.getData() + " ");
        }
    }
    //    • обход дерева «Левый- Вершина -Правый»
    public String LNR()
    {
        StringBuilder ans = new StringBuilder();
        this.LNR(this.root, ans);
        System.out.println();
        return ans.toString();
    }

    private void LNR (Node local, StringBuilder sb)
    {
        if (local != null)
        {
            this.LNR(local.left, sb);
            sb.append(local.getData() + " ");
            System.out.print(local.getData() + " ");
            this.LNR(local.right, sb);
        }
    }

    //    • удаление вершины (опционально);
    public boolean delete(T value) throws  MyException
    {
        if (value == null)
            throw MyException.NullValueInArgument();
        return this.delete(value, this.root, this.root);
    }
    private boolean delete(T value,Node parent, Node current)
    {
        if (current != null) {
            int compare = this.comparator.compare(value, current.data);
            if (compare == 0)
            {
                //нет потомков
                if (current.right == null && current.left == null) {
                    if (current == this.root)
                        this.root = null;
                    else if (parent.left == current)
                        parent.left = null;
                    else
                        parent.right = null;
                }
                //потомок один
                //заменяется левым потомков
                else if (current.right == null)
                    if (current == this.root)
                        this.root = current.left;
                    else if (parent.left == current)
                        parent.left = current.left;
                    else
                        parent.right = current.left;
                    //заменяется правым потомком
                else if (current.left == null)
                    if (current == this.root)
                        this.root = current.right;
                    else if (parent.left == current)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                    //потомков два
                else
                {
                    Node successor = this.getSuccessor(current);
                    if (current == this.root)
                        this.root = successor;
                    else if (parent.left == current)
                        parent.left = successor;
                    else
                        parent.right = successor;
                    successor.left = current.left;
                }
                return true;
            }
            else if(compare < 0)
                return this.delete(value, current, current.left);
            else
                return this.delete(value, current, current.right);
        }
        return false;
    }

    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while(current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.left;

        }
        if (successor != delNode.right)
        {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }
}
