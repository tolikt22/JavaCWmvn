
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = reader.readLine();
            if (string.isEmpty()) break;

            char[] chArr = string.toCharArray();
            String string1 = "", string2 = "",operator;
            char c, tmp;
            int count = 0, countDigit1 = 0, countDigit2 = 0;
            double x = 0, y = 0;
            while (count < chArr.length - 1) {
                c = chArr[countDigit1];
                if (Character.isDigit(c)) {
                    String stTmp = Character.toString(c);
                    string1 = string1.concat(stTmp);
                    x = Double.parseDouble(string1);
                    countDigit1++;
                    countDigit2++;
                    count++;
                } else {
                    countDigit2++;
                    count = countDigit2;
                    tmp = c;
                    operator = Character.toString(tmp);
                    char c2 = chArr[countDigit2];
                    if (Character.isDigit(c2)) {
                        String stTmp = Character.toString(c2);
                        string2 = string2.concat(stTmp);
                        y = Double.parseDouble(string2);
                        calc(x, y, operator);
                    }
                }
            }
        }
    }

    public static void calc(double x, double y, String operator) {
        if (operator.equals("*")) {
            multiply(x, y);
        } else if (operator.equals("/")) {
            divide(x, y);
        } else if (operator.equals("+")) {
            plus(x, y);
        } else if (operator.equals("-")) {
            minus(x, y);
        }
    }

    public static void multiply(double x, double y) {
        System.out.println("результат " + (x * y));
    }

    public static void divide(double x, double y) {
        System.out.println("результат " + (x / y));
    }

    public static void plus(double x, double y) {
        System.out.println("результат " + (x + y));
    }

    public static void minus(double x, double y) {
        System.out.println("результат " + (x - y));
    }
}