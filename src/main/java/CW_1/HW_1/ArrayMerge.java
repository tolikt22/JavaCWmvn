package CW_1.HW_1;

import java.util.Arrays;

public class ArrayMerge {
    public static int[] merge(int[] arr0, int[] arr1) {
        int[] result = new int[arr1.length + arr0.length];

        System.out.println("arr0 - " + Arrays.toString(arr0));
        System.out.println("arr1 - " + Arrays.toString(arr1));

        int index0 = 0;
        int index1 = 0;

        while (result[result.length - 1] == 0) {                       // пока последний элемент result не заполнен
            if (index0 < arr0.length && index1 < arr1.length) {
                if (arr0[index0] <= arr1[index1]) {
                    result[index0 + index1] = arr0[index0++];
                } else {
                    result[index0 + index1] = arr1[index1++];
                }
//                System.out.println(index0 + " " + index1);
            }
            if (index0 == arr0.length && index1 != arr1.length) {      //убрать else
                index0 = arr0.length - 1;
                System.arraycopy(arr1, index1, result, index1 + index0 + 1, arr1.length - index1);
                index1 = arr1.length - 1;
            }
            if (index1 == arr1.length && index0 != arr0.length) {      //убрать else
                index1 = arr1.length - 1;
                System.arraycopy(arr0, index0, result, index1 + index0 + 1, arr0.length - index0);
                index0 = arr0.length - 1;
            }
//            System.out.println(index0 + " " + index1);
            System.out.println("---" + Arrays.toString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayMerge e = new ArrayMerge();
        int[] arr0 = {2, 4, 5, 9, 9, 11};
        int[] arr1 = {1, 3, 5, 8, 10, 15};

        System.out.println("+++" + Arrays.toString(e.merge(arr0, arr1)));
    }
}
