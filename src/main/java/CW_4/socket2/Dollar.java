package CW_4.socket2;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Dollar {
    public static void main(String[] args) throws Exception {
        int c;
        URL url = new URL("http://finance.i.ua/");
        URLConnection connection = url.openConnection();

        //get data
        long d = connection.getDate();
        if (d == 0) {
            System.out.println("No date information");
        } else {
            System.out.println(new Date(d));
        }

        System.out.println("Content type: " + connection.getContentType());

        long len = connection.getContentLengthLong();
        if (len == -1) {
            System.out.println("Content length is not available");
        } else {
            System.out.println("Content length: " + len);
        }
        FileOutputStream fos = new FileOutputStream("tmp.txt");
        if (len != 0) {
            System.out.println("----Content----");
            InputStream is = connection.getInputStream();
            while ((c = is.read()) != -1) {
                fos.write(is.read());
//                System.out.print((char) c);
            }
            is.close();
        } else {
            System.out.println("Content isn't available");
        }
        findKurs(connection.getContentType());
    }
    public static void findKurs(String content){
        String decreaseKurs_ = "USD</th><td><span class=\"value -decrease\"><span>";
        String increaseKurs_ = "</span></span></td><td><span class=\"value -increase\"><span>";
        findValue_1(decreaseKurs_);
        int decreaseKurs=0, increaseKurs=0;

        System.out.println("USD покупка: " + decreaseKurs);
        System.out.println("USD продажа: " + increaseKurs);
    }
    public static double findValue_1(String string) {
        String line = null;

        while (line != null) {
            String x_ = string.substring(string.indexOf(string) + 1);
            double x = Double.parseDouble(x_);
            return x;
        }return 0;
    }

}


