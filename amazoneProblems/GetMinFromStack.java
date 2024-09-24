package amazoneProblems;

// find the minimum element from the stack

import java.util.Comparator;
import java.util.Stack;

public class GetMinFromStack {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(9);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(10);
        for(Integer x : stack){
            if(x<maxValue){
                maxValue = x;
            }
        }
        System.out.println(maxValue);

        Integer i = stack.stream().min(Comparator.naturalOrder()).orElse(null);
        System.out.println(i);
    }
}
