import java.util.Arrays;
import java.util.Scanner;

import sort.Sort;

public class MergeSort {

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        long startTime;
        int arrayLength;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter an length of the array: ");
            arrayLength = scanner.nextInt();
            int[] array = Sort.createRandomArray(arrayLength);
            startTime = System.currentTimeMillis();
            int[] sortedArray = Sort.mergeSort(array);
            System.out.println("The merge sorted array is in correct order: " + isSorted(sortedArray));
            System.out.printf("Merge sort take %.2f s\n", (System.currentTimeMillis() - startTime) / 1000.0);
            startTime = System.currentTimeMillis();
            Sort.bubbleSort(array);
            System.out.println("The bubble sorted array is in correct order: " + isSorted(array));
            System.out.printf("Bubble sort take %.2f s\n", (System.currentTimeMillis() - startTime) / 1000.0);
            System.out.println(
                    "The result of bubble sort and merge sort is the same: " + Arrays.equals(array, sortedArray));

            System.out.print("\n" + "Continue? Please enter yes or no:");
            String yesNo = scanner.next();
            if (yesNo.equals("no"))
                break;
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
