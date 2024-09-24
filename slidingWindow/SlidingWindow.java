package slidingWindow;

import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int windowSize = 4;
        int[] subArray = findingSubArrayMaxValue(array, windowSize);
        for (int SubArray : subArray) {
            System.out.print(SubArray + " ");
        }
    }

    public static int[] findingSubArrayMaxValue(int[] array, int windowSize) {
        int left = 0;
        int right;
        int sum = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        for (right = 0; right < array.length; right++) {
            sum += array[right];
            if (right - left + 1 == windowSize) {
                if (sum > maxSum) {
                    maxSum = sum;
                    rightIndex = right;
                    leftIndex = left;
                }
                sum -= array[left];
                left++;
            }
        }
        System.out.println("\n" + maxSum);
        return Arrays.copyOfRange(array, leftIndex, rightIndex);
    }
}
