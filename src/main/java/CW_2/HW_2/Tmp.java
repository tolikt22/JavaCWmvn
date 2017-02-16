import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Tmp {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> dict = null;
        Scanner in = new Scanner(new File("c://dict.txt"));
        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] tmpSt = string.split(" ");
            for (int i = 0; i < tmpSt.length; i++) {
                String[] tmp = new String[2];
                tmp[0] = tmpSt[i].substring(0, tmpSt[i].lastIndexOf("-"));
                tmp[1] = tmpSt[i].substring(tmpSt[i].lastIndexOf("-") + 1);
                dict.put(tmp[0], tmp[1]);
            }
        }
        Iterator iter = dict.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pairs = (Map.Entry) iter.next();
                System.out.println(pairs.getValue().toString());
        }
    }
}
