package treeProblems.allFunctionality;

public class Main {
    public static void main(String[] args) {
        Binary binary = new Binary();

        binary.root = new TreeNode(8);
        binary.root.left = new TreeNode(3);
        binary.root.left.left = new TreeNode(12);
        binary.root.left.left.right = new TreeNode(4);
        binary.root.left.left.right.left = new TreeNode(9);
        binary.root.left.left.right.right = new TreeNode(7);
        binary.root.right = new TreeNode(5);
        binary.root.right.left = new TreeNode(10);
        binary.root.right.right = new TreeNode(6);
        binary.root.right.right.left = new TreeNode(2);
        binary.levelOrder(binary.root);
        int nodeCount = binary.countNode(binary.root);
        System.out.println("Total number of node -> " + nodeCount);
        int leafNodeCount = binary.leafNode(binary.root);
        System.out.println("Total number of leaf node -> " + leafNodeCount);
        int nonLeafNode = binary.nonLeafNode(binary.root);
        System.out.println("Non leaf node -> " + nonLeafNode);
        int degree_2 = binary.countDegree_2(binary.root);
        System.out.println("Degree_2 node -> " + degree_2);
        int degree_1 = binary.countDegree_1(binary.root);
        System.out.println("degree_1 is ->" + degree_1);

        binary.recursionHelper(30);
        binary.recursionHelper(20);
        binary.recursionHelper(35);
        binary.recursionHelper(10);
        binary.recursionHelper(31);
        binary.levelOrder(binary.root1);

        boolean result = binary.searchKey(binary.root1, 10);
        if (result) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
