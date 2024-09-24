package linkedlist.singlylinked;

public class SinglyLinkedList {
    public int size;
    public Node head;
    public Node tail;
    public boolean isCreated = false;

    // Create Node
    public Node createNode(int nodeValue) {
        if (isCreated) {
            System.out.println("Node already created");
            return head;
        }
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        isCreated = true;
        size++;
        return head;
    }

    // add at first
    public void addFirst(int nodeValue) {
        if (head != null) {
            Node newNode = new Node();
            newNode.value = nodeValue;
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            System.out.println("please create node first call this method to create node 'createNode' ");
        }
    }

    // add at last
    public void addLast(int nodeValue) {
        if (tail != null) {
            Node newNode = new Node();
            newNode.value = nodeValue;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            size++;
        } else {
            System.out.println("please create node first call this method to create node 'createNode' ");
        }
    }

    // print
    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
        System.out.println("size of linked list is - " + size);
    }

    // add at position
    public void addAtGivenPosition(int nodeValue, int position) {
        if (head != null) {
            Node currentPointer = head;
            Node followingPointer = null;
            for (int i = 1; i <= position; i++) {
                if (i == position) {
                    Node newNode = new Node();
                    newNode.value = nodeValue;
                    newNode.next = followingPointer.next;
                    followingPointer.next = newNode;
                    size++;
                }
                followingPointer = currentPointer;
                currentPointer = currentPointer.next;
            }
        }
    }
}
