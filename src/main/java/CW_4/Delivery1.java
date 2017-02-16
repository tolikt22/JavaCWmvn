package CW_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Delivery1 {
    public static void main(String[] args) {
        ExecutorService lorry = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            lorry.submit(new Parcel1());
        }
        lorry.shutdown(); //
    }

    static class Parcel1 implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Go");
                Thread.sleep(2000);
                System.out.println("Back");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


