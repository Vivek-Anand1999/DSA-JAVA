package treeProblems.practise;

import java.util.LinkedList;
import java.util.Queue;

//!# Driver code
public class PrintWithNull {
    public static void main(String[] args) {
        Binary1Tree binary1Tree = new Binary1Tree();
        binary1Tree.createRoot(1);
        binary1Tree.leftChild(2);
        binary1Tree.rightChild(3);
        binary1Tree.rightChild(5);
        binary1Tree.levelOrder(binary1Tree.root);
    }
}

class Binary1Tree {
    public Node root;
    public Node pointer;

    Queue<Node> nodeAddress = new LinkedList<>();

    public void createRoot(int val) {
        if (root != null) {
            return;
        }
        Node newNode = new Node(val);
        root = newNode;
        nodeAddress.add(newNode);
    }

    public void leftChild(int val) {
        if (root == null && root.left != null) {
            return;
        }
        Node newNode = new Node(val);
        pointer = nodeAddress.poll();
        pointer.left = newNode;
        nodeAddress.add(newNode);
    }

    public void rightChild(int val) {
        if (root == null && root.right != null) {
            return;
        }
        if (pointer.right != null) {
            pointer = nodeAddress.poll();
        }
        Node newNode = new Node(val);
        pointer.right = newNode;
        nodeAddress.add(newNode);
    }

    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        Node temp = root;
        System.out.println(temp.data);
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.left == null) {
                System.out.println("null");
            }
            if (temp.left != null) {
                System.out.println(temp.left.data);
                q.add(temp.left);
            }
            if (temp.right != null) {
                System.out.println(temp.right.data);
                q.add(temp.right);
            }
        }

    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}