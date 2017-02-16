package CW_1.HW_1;

import java.util.Arrays;

/**
 * Created by tolik on 22.01.2017.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{45, 85, 65, 25, 75, 95, 35, 15, 74, 58, 96, 36, 52, 14, 19};

        int j; //**

        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];

            for (j = i - 1; j >= 0 && tmp < array[j]; j--) { //от index < на 1 позицию до 0
                array[j + 1] = array[j]; //сначала на место tmp
            }
            array[j + 1] = tmp; //** tmp сюда
        }
        System.out.println(Arrays.toString(array));
    }
}
