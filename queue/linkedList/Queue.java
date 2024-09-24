package queue.linkedList;

public class Queue {
    public Node rear;
    public Node front;

    public Queue() {
        rear = null;
        front = null;
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    public void createNode(int nodeValue) {
        if (front == null) {
            Node newNode = new Node();
            newNode.data = nodeValue;
            newNode.next = null;
            front = newNode;
            rear = newNode;
        } else {
            Node newNode = new Node();
            newNode.data = nodeValue;
            newNode.next = null;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void print() {
        Node followingNode = front;
        while (followingNode != null) {
            System.out.print(followingNode.data + "->");
            followingNode = followingNode.next;
        }
    }

}
