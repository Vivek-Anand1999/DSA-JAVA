package treeProblems.avl;


public class Avl {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.createAvl(10);
        avlTree.createAvl(30);
        avlTree.createAvl(20);
        avlTree.inOrderTraversal(avlTree.root);
        System.out.println();
        System.out.println("root = " + avlTree.root.data);
    }
}

class TreeNode {
    public int data;
    public int height;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.height = 1; // Start height at 1 for a new node
        this.left = null;
        this.right = null;
    }
}

class AvlTree {

    public TreeNode root;

    // Insert a node and create an AVL tree
    public void createAvl(int key) {
        root = insert(root, key);
    }

    // Recursive function to insert and balance the AVL tree
    private TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicate keys are not allowed
        }
        node.height = nodeHeight(node);
        int balanceFactorOfNode = balanceFactor(node);
        if (balanceFactorOfNode == 2 && balanceFactor(node.left) == 1) { //ll
            //ll Rotations
            return llRotation(node);
        } else if (balanceFactorOfNode == 2 && balanceFactor(node.left) == -1) { //Lr
            //lr Rotations
            return lrRotations(node);
        } else if (balanceFactorOfNode == -2 && balanceFactor(node.right) == -1) { // rr
            //rr Rotations
            return rrRotations(node);
        } else if (balanceFactorOfNode == -2 && balanceFactor(node.right) == 1) { //rl
            //rl Rotations
            return rlRotations(node);
        }

        return node;
    }

    //finding the height of a tree
    public int nodeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight;
        int rightHeight;
        leftHeight = node != null && node.left != null ? node.left.height : 0;
        rightHeight = node != null && node.right != null ? node.right.height : 0;
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight;
        int rightHeight;
        leftHeight = node != null && node.left != null ? node.left.height : 0;
        rightHeight = node != null && node.right != null ? node.right.height : 0;
        return leftHeight - rightHeight;
    }

    // LL Rotation
    public TreeNode llRotation(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode pointer = node.left;
        node.left = pointer.right;
        pointer.right = node;
        node.height = nodeHeight(node);
        pointer.height = nodeHeight(pointer);
        return pointer;
    }

    //RR Rotate
    public TreeNode rrRotations(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode pointer = node.right;
        node.right = pointer.left;
        pointer.left = node;
        node.height = nodeHeight(node);
        pointer.height = nodeHeight(pointer);
        return pointer;
    }

    //lr Rotations
    public TreeNode lrRotations(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = rrRotations(node.left);
        return llRotation(node);
    }

    //rl Rotations
    public TreeNode rlRotations(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.right = llRotation(node.right);
        return rrRotations(node);
    }


    // Inorder traversal to display the tree
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + "  ");
        inOrderTraversal(node.right);
    }

}