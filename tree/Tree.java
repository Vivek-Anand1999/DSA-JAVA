package tree;

import javax.print.DocFlavor;
import java.util.*;

public class Tree {
    public Node pointer;
    public Node root;
    Queue<Node> queue = new LinkedList<>();

    public void createTree(int val) {
        Node newNode = new Node();
        if (root == null) {
            root = newNode;
            newNode.data = val;
            queue.add(newNode);
        }
    }

    public void leftChild(int val) {
        Node newNode = new Node();
        if (root != null) {
            pointer = queue.poll();
            newNode.data = val;
            pointer.left = newNode;
            queue.add(newNode);

        }
    }

    public void rightChile(int val) {
        Node newNode = new Node();
        if (root != null) {
            if (pointer.right == null) {
                newNode.data = val;
                pointer.right = newNode;
                queue.add(newNode);
            }
        }
    }

    // preOrder printing
    public void preOrderPrinting() {
        Stack<Node> nodeAddress = new Stack<>();
        Node temp = root;
        if (temp == null) {
            return;
        }
        while (temp != null || !nodeAddress.isEmpty()) {
            if (temp != null) {
                System.out.println(temp.data);
                nodeAddress.push(temp);
                temp = temp.left;
            } else {
                temp = nodeAddress.pop();
                temp = temp.right;
            }
        }
    }

    //InOrder printing
    public void inOrderPrinting() {
        Stack<Node> nodeAddress = new Stack<>();
        Node temp = root;
        if (temp == null) {
            return;
        }
        while (temp != null || !nodeAddress.isEmpty()) {
            if (temp != null) {
                nodeAddress.push(temp);
                temp = temp.left;
            } else {
                temp = nodeAddress.pop();
                System.out.println(temp.data);
                temp = temp.right;
            }
        }
    }

    //postOrder
    public void postOrder() {
        Node temp = root;
        if (temp == null) {
            return;
        }
        Stack<Node> nodeAddress = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (temp != null || !nodeAddress.isEmpty()) {
            if (temp != null) {
                list.add(temp.data);
                nodeAddress.push(temp);
                temp = temp.right;
            } else {
                temp = nodeAddress.pop();
                temp = temp.left;
            }
        }
        Collections.reverse(list);
        for (Integer data : list) {
            System.out.println(data);
        }
    }

    //LevelOrder
    public void levelOrder() {
        Node temp = root;
        Queue<Node> nodeAddress = new LinkedList<>();
        if (temp == null) {
            return;
        }
        System.out.println(temp.data);
        nodeAddress.add(temp);
        while (!nodeAddress.isEmpty()) {
            temp = nodeAddress.poll();
            if (temp.left != null) {
                System.out.println(temp.left.data);
                nodeAddress.add(temp.left);
            }
            if (temp.right != null) {
                System.out.println(temp.right.data);
                nodeAddress.add(temp.right);
            }
        }
    }
}
