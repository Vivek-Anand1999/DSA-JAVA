package linkedlist.circularLinkedList;

public class CircularLinkedList {

    public int size;
    public Node head;
    public Node tail;
    public boolean isCreated = false;

    public Node createNode(int nodeValue) {
        if (isCreated) {
            System.out.println("Node already craeted; ");
            return head;
        } else {
            Node newNode = new Node();
            newNode.data = nodeValue;
            head = newNode;
            tail = newNode;
            newNode.next = head;
            size++;
            isCreated = true;
            size++;
            return head;
        }
    }

    public void addLast(int nodeValue){
        if(head != null){
            Node newNode = new Node();
            newNode.data = nodeValue;
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
            size++;
        }
        else {
            System.out.println("please create node first call this method -> 'createNode' ");
        }
    }

    public void printLinkedList(){
        Node currentPointer = head;
        while (currentPointer != null){
            System.out.print(currentPointer.data + "->");
            currentPointer = currentPointer.next;
        }
    }
}
