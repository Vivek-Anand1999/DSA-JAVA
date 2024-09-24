package slidingWindow;

import java.util.*;

public class FindingFirstNegativeNumber {
    //Driver code
    public static void main(String[] args) {
        int[] array = {-12, -1, -7, 8, -15, 30, 16, 25};
        int windowSize = 3;
        printFirstNegavtiveInteger(array, windowSize);
    }

    public static void printFirstNegavtiveInteger(int[] array, int windowSize) {
        List<Integer> allFirstNegativeNumber = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int left = 0;
        int right;
        for (right = 0; right < array.length; right++) {
            if (array[right] < 0) {
                queue.add(array[right]);
            }
            if (right - left + 1 == windowSize) {
                if (!queue.isEmpty()) {
                    allFirstNegativeNumber.add(queue.peek());
                } else {
                    allFirstNegativeNumber.add(0);
                }
                if (array[left] < 0) {
                    queue.poll();
                }
                left++;
            }
        }
        System.out.println(allFirstNegativeNumber);
    }
}
