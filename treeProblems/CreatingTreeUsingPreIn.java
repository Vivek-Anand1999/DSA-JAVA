package treeProblems;

import java.util.*;

public class CreatingTreeUsingPreIn {
    public static void main(String[] args) {
        List<Integer> preOrder = new ArrayList<>(List.of(4, 7, 9, 6, 3, 2, 5, 8, 1));
        List<Integer> inOrder = new ArrayList<>(List.of(7, 6, 9, 3, 4, 5, 8, 2, 1));
        TreeNode root = createTree(preOrder, inOrder);

        //print By level
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        if (root == null) {
            return;
        }
        System.out.println(temp.val);
        queue.add(temp);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Loop through all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                temp = queue.poll();

                // Print left child if it exists and add to queue
                if (temp.left != null) {
                    System.out.print(temp.left.val + " ");
                    queue.add(temp.left);
                }

                // Print right child if it exists and add to queue
                if (temp.right != null) {
                    System.out.print(temp.right.val + " ");
                    queue.add(temp.right);
                }
            }
            // Move to the next line after printing all nodes at the current level
            System.out.println();
        }
    }

    public static TreeNode createTree(List<Integer> preOrder, List<Integer> inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inMap.put(inOrder.get(i), i);
        }
        return createNodeOfTree(preOrder, 0, preOrder.size() - 1, inOrder, 0, inOrder.size() - 1, inMap);
    }

    public static TreeNode createNodeOfTree(List<Integer> preOrder, int preStart, int preEnd, List<Integer> inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = preOrder.get(preStart);
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = inMap.get(rootValue);
        int numLeft = rootIndex - inStart;
        root.left = createNodeOfTree(preOrder, preStart + 1, preStart + numLeft, inOrder, inStart, rootIndex - 1, inMap);
        root.right = createNodeOfTree(preOrder, preStart + numLeft + 1, preEnd, inOrder, rootIndex + 1, inEnd, inMap);
        return root;
    }
}