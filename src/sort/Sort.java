package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(10, 100);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = array[j];
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        int arrayLength1 = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, arrayLength1);
        int[] array2 = Arrays.copyOfRange(array, arrayLength1, array.length);
        array1 = mergeSort(array1);
        array2 = mergeSort(array2);
        int[] mergedArray = merge(array1, array2);

        return mergedArray;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (j < array1.length && k < array2.length) {
            if (array1[j] > array2[k]) {
                mergedArray[i++] = array2[k++];
            } else {
                mergedArray[i++] = array1[j++];
            }
        }
        while (j < array1.length) {
            mergedArray[i++] = array1[j++];
        }
        while (k < array2.length) {
            mergedArray[i++] = array2[k++];
        }
        return mergedArray;
    }
}
