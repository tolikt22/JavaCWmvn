package CW_4.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.matroluxe.pl.ua");
        System.out.println(address);

        InetAddress sw[] = InetAddress.getAllByName("www.sweet-sleep.com.ua");
        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);
        }

    }
}


