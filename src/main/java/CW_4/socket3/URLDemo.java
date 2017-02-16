package CW_4.socket3;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html");
        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Port: "+url.getPort());
        System.out.println("Host: "+url.getHost());
        System.out.println("File: "+url.getFile());
        System.out.println("Full URL: "+url.toExternalForm());
    }
}
