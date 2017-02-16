package CW_1.HW_1;

import java.util.Arrays;

/**
 * Created by tolik on 22.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{45, 85, 65, 25, 75, 95, 35, 15, 74, 58, 96, 36, 52, 14, 19};
        int min = 0;
        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    min = array[j];
                    array[j] = array[j+1];
                    array[j+1] = min;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(min);
    }
}
