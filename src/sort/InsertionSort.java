package sort;

import java.util.Arrays;

/**
 * Created by sasanka on 6/28/15.
 */
public class InsertionSort {

    public static void main(String args[]) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        System.out.println("array = " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j=i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }
}
