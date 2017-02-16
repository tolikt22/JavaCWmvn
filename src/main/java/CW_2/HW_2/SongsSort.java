package CW_2.HW_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SongsSort {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new File("songs.txt"));

        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] tmpSt = string.split("_");

            for (int i = 0; i < tmpSt.length; i++) {
                String tmp = tmpSt[i].substring(0, tmpSt[i].length());
                list.add(i, tmp);
            }
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
