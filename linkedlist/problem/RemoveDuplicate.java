package linkedlist.problem;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class RemoveDuplicate {
    public static void main(String[] args) {
        LinkedList<Integer> dataValue = new LinkedList<>();
        dataValue.add(9);
        dataValue.add(8);
        dataValue.add(5);
        dataValue.add(10);
        Collections.sort(dataValue);
        int i = Collections.binarySearch(dataValue, 8);
        System.out.println(i);
    }
}
