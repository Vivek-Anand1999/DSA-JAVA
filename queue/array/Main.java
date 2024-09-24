package queue.array;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(2);
        queue.enQueue(2);
        queue.enQueue(2);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(9);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.printQueue();
        System.out.println(queue.front);
        System.out.println(queue.rear);

    }

}
