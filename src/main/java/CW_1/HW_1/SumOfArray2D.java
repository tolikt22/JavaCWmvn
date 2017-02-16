package CW_1.HW_1;

/**
 * Created by tolik on 22.01.2017.
 */
public class SumOfArray2D {
    public static void main(String[] args) {

        int result = 0;

        int[][] array = new int[8][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 100);
                result += array[i][j];
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Сумма чисел массива: " + result);
    }
}
