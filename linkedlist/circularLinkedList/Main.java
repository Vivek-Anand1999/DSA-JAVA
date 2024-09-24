package linkedlist.circularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.createNode(1);
        circularLinkedList.addLast(5);
        circularLinkedList.addLast(8);
        circularLinkedList.printLinkedList();
    }
}
