package treeProblems.allFunctionality;

import java.util.LinkedList;
import java.util.Queue;

public class Binary {
    public TreeNode root;
    public TreeNode pointer;
    public TreeNode root1;
    public TreeNode temp1;
    Queue<TreeNode> address = new LinkedList<>();

    public void levelOrder(TreeNode temp) {
        if (temp == null) {
            return;
        }

        Queue<TreeNode> nodeAddress = new LinkedList<>();
        pointer = temp;

        nodeAddress.add(pointer);

        // While there are nodes to process
        while (!nodeAddress.isEmpty()) {
            int levelSize = nodeAddress.size(); // Number of nodes at the current level

            // Print all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                pointer = nodeAddress.poll();
                System.out.print(pointer.data + " ");

                // Add left child to the queue
                if (pointer.left != null) {
                    nodeAddress.add(pointer.left);
                }

                // Add right child to the queue
                if (pointer.right != null) {
                    nodeAddress.add(pointer.right);
                }
            }
            // Move to the next line after printing all nodes at the current level
            System.out.println();
        }
    }

    public int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNode(root.left);
        int right = countNode(root.right);
        return left + right + 1;
    }

    public int leafNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = leafNode((root.left));
        int right = leafNode(root.right);
        if (root.left == null && root.right == null) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

    public int nonLeafNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = nonLeafNode(root.left);
        int right = nonLeafNode(root.right);
        if (root.left != null || root.right != null) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

    public int countDegree_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countDegree_2(root.left);
        int right = countDegree_2(root.right);
        if (root.left != null && root.right != null) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

    public int countDegree_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countDegree_1(root.left);
        int right = countDegree_1(root.right);
        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

    public void binarySearchTree(int val) {
        if (root1 == null) {
            root1 = new TreeNode(val);
            return;
        }
        temp1 = root1;
        TreeNode parent = null;
        while (temp1 != null) {
            parent = temp1;
            if (val < temp1.data) {
                temp1 = temp1.left;
            } else if (val > temp1.data) {
                temp1 = temp1.right;
            } else {
                return;
            }
        }
        if (val < parent.data) {
            TreeNode newNode = new TreeNode(val);
            parent.left = newNode;
        }
        if (val > parent.data) {
            TreeNode newNode = new TreeNode(val);
            parent.right = newNode;
        }

    }

    public TreeNode recursionHelper(int val) {
        root1 = binarySearch(root1, val);
        return root1;
    }

    public TreeNode binarySearch(TreeNode root1, int val) {
        if (root1 == null) {
            root1 = new TreeNode(val);
            return root1;
        }
        if (val < root1.data) {
            root1.left = binarySearch(root1.left, val);
        } else if (val > root1.data) {
            root1.right = binarySearch(root1.right, val);
        }
        return root1;
    }

    public boolean searchKey(TreeNode root1, int key) {
        if (root1 == null) {
            return false;
        }
        if (key == root1.data) {
            return true;
        } else if (key < root1.data) {
            return searchKey(root1.left, key);
        } else if (key > root1.data) {
            return searchKey(root1.right, key);
        }
        return false;
    }
}
