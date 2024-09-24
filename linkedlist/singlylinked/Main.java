package linkedlist.singlylinked;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.createNode(2);
        singlyLinkedList.addLast(4);
        singlyLinkedList.addLast(5);
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addAtGivenPosition(3,3);
        singlyLinkedList.printLinkedList();
    }
}
