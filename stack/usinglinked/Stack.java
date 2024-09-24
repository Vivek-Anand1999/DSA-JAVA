package stack.usinglinked;

public class Stack {

    public int size;
    public Node top;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        Node newNode = new Node();
        if (newNode == null) {
            return true;
        }
        return false;
    }

    public void push(int nodeValue) {
        Node newNode = new Node();
        if (newNode == null) {
            System.out.println("stack is full");
        } else {
            if (top == null) {
                newNode.data = nodeValue;
                newNode.next = null;
                top = newNode;
                size++;
            } else {
                newNode.data = nodeValue;
                newNode.next = top;
                top = newNode;
                size++;
            }
        }

    }

    public void pop() {
        if (isEmpty()) {
            return;
        } else {
            Node deleingPointer = top;
            top = top.next;
            deleingPointer.next = null;
            size--;
        }
    }

    public void peek(int position) {
        if (isEmpty()) {
            return;
        } else {
            Node followingPointer = top;
            for (int i = 0; i < position - 1 && followingPointer != null; i++) {
                followingPointer = followingPointer.next;
            }
            if (followingPointer != null) {
                System.out.println(followingPointer.data);
            }
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        Node followingPointer = top;
        while (followingPointer != null) {
            System.out.println(followingPointer.data);
            followingPointer = followingPointer.next;
        }
    }

}
