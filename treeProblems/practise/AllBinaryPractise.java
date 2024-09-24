package treeProblems.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllBinaryPractise {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRoot(1);
        binaryTree.leftChild(2);
        binaryTree.rightChild(3);
        binaryTree.leftChild(4);
        binaryTree.rightChild(5);
        binaryTree.leftChild(6);
        binaryTree.rightChild(7);
        List<Integer> l = binaryTree.helper(binaryTree.root);
        System.out.println(l);
//        binaryTree.levelOrder();


    }
}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    public TreeNode root;
    public TreeNode pointer;

    Queue<TreeNode> nodeAddress = new LinkedList<>();

    public void createRoot(int val) {
        if (root != null) {
            return;
        }
        TreeNode newNode = new TreeNode(val);
        root = newNode;
        nodeAddress.add(newNode);
    }

    public void leftChild(int val) {
        if (root == null && root.left != null) {
            return;
        }
        TreeNode newNode = new TreeNode(val);
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
        TreeNode newNode = new TreeNode(val);
        pointer.right = newNode;
        nodeAddress.add(newNode);
    }

    //printing by level order
    public void levelOrder() {
        Queue<TreeNode> nodeAddress = new LinkedList<>();
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        System.out.println("  " + temp.data);
        nodeAddress.add(temp);
        while (!nodeAddress.isEmpty()) {
            int levelOfTree = nodeAddress.size();
            for (int i = 0; i < levelOfTree; i++) {
                temp = nodeAddress.poll();
                if (temp.left != null) {
                    System.out.print(temp.left.data + "    ");
                    nodeAddress.add(temp.left);
                }
                if (temp.right != null) {
                    System.out.print(temp.right.data + "    ");
                    nodeAddress.add(temp.right);
                }
            }
            System.out.println();

        }
    }

    //recursion call inOrder
    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);
    }

    public List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }
}