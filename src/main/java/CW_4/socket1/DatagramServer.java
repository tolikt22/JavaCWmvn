package CW_4.socket1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {

    public static int serverPort = 9098;
    public static int clientPort = 9099;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void theServer() throws Exception {
        System.out.println("Server start");
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Сервер завершил работу.");
                    ds.close();
                    return;
                case '\r':

                    break;
                case '\n':
                    ds.send(new DatagramPacket(buffer, pos,
                            InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ds = new DatagramSocket(serverPort);
        theServer();
    }

}
