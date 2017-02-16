package CW_1.HW_1;

import java.util.Arrays;

/**
 * Created by tolik on 22.01.2017.
 *///cортировка выбором.
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{45, 85, 65, 25, 75, 95, 35, 15, 74, 58, 96, 36, 52, 14, 19};

        for (int j = 0; j < array.length; j++) {
            int max = array[j];
            int maxIndex = j;

            for (int i = j; i < array.length - 1; i++) {  // уменьшаем проверяемую область i=j
                if (max > array[i + 1]) {
                    max = array[i + 1];
                    maxIndex = i + 1;
                }
            }
            int tmp = array[j];
            array[j] = max;
            array[maxIndex] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
}

/*from wiki

public static void sort (int[] arr) {

    for (int min=0;min<arr.length-1;min++) {
        int least = min;

        for (int j=min+1;j<arr.length;j++) {
            if(arr[j] < arr[least]) {
                least = j;
            }
        }
        int tmp = arr[min];
        arr[min] = arr[least];
        arr[least] = tmp;
    }
}*/
