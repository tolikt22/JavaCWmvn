import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Vocabulary {

    public static String readUserWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        return word;
    }

    public static String getPair(HashMap dict, String word) {
        Iterator iter = dict.entrySet().iterator();
        String pair = "";
        while (iter.hasNext()) {
            Map.Entry pairs = (Map.Entry) iter.next();
            if (pairs.getKey().equals(word)) {
                pair = pairs.getValue().toString();
            }
        }
        return pair;
    }

    public static HashMap<String, String> fileToMap(String path) throws FileNotFoundException {
        HashMap<String, String> dict = new HashMap<>();
        Scanner in = new Scanner(new File(path));

        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] tmpSt = string.split(" ");              //   ?

            for (int i = 0; i < tmpSt.length; i++) {
                String[] tmp = new String[2];
                tmp[0] = tmpSt[i].substring(0, tmpSt[i].lastIndexOf("-"));
                tmp[1] = tmpSt[i].substring(tmpSt[i].lastIndexOf("-") + 1);
                dict.put(tmp[0], tmp[1]);
            }
        }
        return dict;
    }

    public static void main(String[] args) throws IOException {
        String path = "dict.txt";
            System.out.println(getPair(fileToMap(path),readUserWord()));
    }
}
