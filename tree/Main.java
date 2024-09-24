package tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createTree(1);
        tree.leftChild(2);
        tree.rightChile(3);
        tree.leftChild(4);
        tree.levelOrder();
    }
}
