package CW_1.HW_1;

import java.util.Arrays;

/**
 * Created by tolik on 22.01.2017.
 */
public class ReverseBubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{45, 85, 65, 25, 75, 95, 35, 15, 74, 58, 96, 36, 52, 14, 19};
        // пузырек двигается влево
        int max;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    max = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = max;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
