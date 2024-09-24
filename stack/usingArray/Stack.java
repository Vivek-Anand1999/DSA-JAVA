package stack.usingArray;


public class Stack {

    public int[] stack;
    public int top;
    public int size;

    public Stack(int size) {
        stack = new int[size];
        this.size = stack.length;
        top = -1;
    }

    public void push(int value) {
        if (!isFull()) {
            top++;
            stack[top] = value;
        } else {
            System.out.println("Stack is full");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            int temp = stack[top];
            top--;
        } else {
            System.out.println("Stack is empty we can not perform pop operation");
        }
    }

    public int peek(int position) {
        int mappingPointer = top - position + 1;
        if (mappingPointer < 0 || position == 0) {
            return -1;
        }
        return stack[mappingPointer];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        }
        return false;
    }

    public void printStack() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        } else {
            System.out.println("Stack is empty");
        }
    }
}
