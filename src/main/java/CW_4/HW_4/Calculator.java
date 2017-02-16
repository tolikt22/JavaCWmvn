package CW_4.HW_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = reader.readLine();
            if (string.isEmpty()) break;
            char operator = findOperator(string);
            String[] tmp = string.split(String.valueOf("\\" + operator));  //без "\\" + и * вызывают ошибку
            double result = calc(findValue_1(tmp[0], operator), findValue_2(tmp[1], operator), operator);
            System.out.println("результат: " + result);
        }
    }

    public static char findOperator(String string) {
        char[] chars = string.toCharArray();
        char operat = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isDigit(c) && c != '.') operat = c;
        }
        return operat;
    }

    public static double findValue_1(String string, char oper) {
        String x_ = string.substring(string.indexOf(oper) + 1);
        double x = Double.parseDouble(x_);
        return x;
    }

    public static double findValue_2(String string, char oper) {
        String y_ = string.substring(string.indexOf(oper) + 1);
        double y = Double.parseDouble(y_);
        return y;
    }

    public static double calc(double x, double y, char operat) {
        String operator = "" + operat;
        double result = 0;
        if (operator.equals("*")) {
            result = multiply(x, y);
        } else if (operator.equals("/")) {
            result = divide(x, y);
        } else if (operator.equals("+")) {
            result = plus(x, y);
        } else if (operator.equals("-")) {
            result = minus(x, y);
        }
        return result;
    }

    public static double multiply(double x, double y) {
        return (x * y);
    }

    public static double divide(double x, double y) {
        return (x / y);
    }

    public static double plus(double x, double y) {
        return (x + y);
    }

    public static double minus(double x, double y) {
//        NumberFormat nf = new DecimalFormat("#.######");
//        String s = nf.format(x-y);
//        double d = Double.parseDouble(s);
//        return d;
        return (x-y);
    }
}
