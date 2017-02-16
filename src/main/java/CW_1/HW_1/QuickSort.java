package CW_1.HW_1;

import java.util.Arrays;

/**
 * Created by tolik on 26.01.2017. QuickSort with recursion
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{45, 85, 65, 25, 75, 95, 35, 15, 74, 58, 96, 36, 52, 14, 19};
        qs(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void qs(int items[], int left, int right) {

        int i, j;
        int x, y; // x - середина каждого нового массива (половины предыдущего), y - пустой стакан

        i = left;
        j = right;

        x = items[(left + right) / 2];

        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;

            if (i <= j) {

                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;

            }
        } while (i <= j);
        if (left < j) qs(items, left, j);          //рекурсия
        if (i < right) qs(items, i, right);
    }
}



