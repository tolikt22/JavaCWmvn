package CW_1;
/**
 * Created by java-2-06 on 22.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5,5,6,84,58,556,554,58,14};

        int max ;

        for (int i = array.length-1; i>=0; i--) {
            for (int j = 0; j < i ; j++) {
                if(array[j]<array[j+1]){
                    max = array[j+1];
                    array[j+1] = array[j];
                    array[j] = max;
                }
                }
            }
        for(int i : array)
            System.out.print(i+" ");
        }
    }
