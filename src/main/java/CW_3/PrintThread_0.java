package CW_3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintThread_0 extends Thread {

    private String message;

    public PrintThread_0(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message + " - " + i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintThread_0.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintThread_0 printThread = new PrintThread_0("print");
        printThread.setDaemon(true);
        printThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main method");
            sleep(1000);
        }
//        printThread.join();
        System.out.println("finish main");
    }
}