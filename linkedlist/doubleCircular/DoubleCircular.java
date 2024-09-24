package linkedlist.doubleCircular;

import java.util.logging.Logger;

public class DoubleCircular {

    public int size;
    public Node head;
    public Node tail;
    public boolean isCreated = false;


    private static final Logger log = Logger.getLogger(DoubleCircular.class.getName());

    public Node creatNode(int nodeValue){
        if(isCreated){
            log.info("Node are already created");
            return head;
        }
        else{
            Node newNode = new Node();
            newNode.data = nodeValue;
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
            size++;
            isCreated = true;
            return head;
        }
    }
}
