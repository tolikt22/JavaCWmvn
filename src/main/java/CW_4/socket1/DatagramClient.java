package CW_4.socket1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramClient {

    public static int clientPort = 9099;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void theClient() throws Exception {
        System.out.println("Client start");
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String args[]) throws Exception {
        ds = new DatagramSocket(clientPort);
        theClient();
    }
}
