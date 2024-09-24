package queue.array;

public class Queue {
    public int[] queue;
    public int front;
    public int rear;

    public Queue(int size) {
        queue = new int[size];
        front = 0;
        rear = 0;
        System.out.println("queue created for size " + size);
    }

    public boolean isFull() {
        if (rear == queue.length - 1 && front == 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    public void enQueue(int value) {
        if ((rear + 1) % queue.length == front) {
            System.out.println("Queue is full");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            int i = (front + 1) % queue.length;
            while (i != (rear + 1) % queue.length) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % queue.length;
            }
        }
        System.out.println();
    }

    public void deQueue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        } else {
            front = (front + 1) % queue.length;
            queue[front] = 0;
        }
    }
}
