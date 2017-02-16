package CW_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Delivery {
    public static void main(String[] args) {
        ExecutorService lorry = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            lorry.submit(new Parcel());
        }

    }

    static class Parcel implements Runnable {

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

