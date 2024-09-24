package linkedlist.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.createNode(1);
        doublyLinkedList.addLast(8);
        doublyLinkedList.addLast(9);
        doublyLinkedList.printPrevious();
        doublyLinkedList.printPrevious();
    }
}
