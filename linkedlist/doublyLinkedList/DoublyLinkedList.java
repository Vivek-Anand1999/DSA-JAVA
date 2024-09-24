package linkedlist.doublyLinkedList;

import java.util.logging.Logger;

public class DoublyLinkedList {

    public int size;
    public Node head;
    public Node tail;
    public boolean isCreated = false;
    public boolean isInitialized = false;
    public  Node followingPointer;

    private static final Logger log = Logger.getLogger(DoublyLinkedList.class.getName());

    public Node createNode(int nodeValue) {
        if (isCreated) {
            log.info("Node is already created");
            return head;
        } else {
            Node newNode = new Node();
            newNode.data = nodeValue;
            newNode.prev = null;
            newNode.next = null;
            head = newNode;
            tail = newNode;
            isCreated = true;
            size++;
            return head;
        }
    }

    public void addLast(int nodeValue) {
        if (head != null) {
            Node newNode = new Node();
            newNode.data = nodeValue;
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        } else {
            System.out.println("please create node first");
        }
    }

    public void printPrevious() {
        log.info("v,svkbsvksfb");
        if (!isInitialized) {
            followingPointer = tail;
            isInitialized = true;
        }
        if (isInitialized) {
            if (followingPointer != null) {
                System.out.println(followingPointer.data);
                followingPointer = followingPointer.prev;
                if (followingPointer == null) {
                    System.out.println("We have reached the first node");
                    isInitialized = false; // Optionally reset to allow re-traversal from the end
                }
            } else {
                System.out.println("followingPointer is null");
            }
        }
    }


    public void printNext() {

    }
}
