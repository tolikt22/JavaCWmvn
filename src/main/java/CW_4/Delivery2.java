package CW_4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Delivery2 {
    public static void main(String[] args) {
        ScheduledExecutorService lorry = Executors.newScheduledThreadPool(2);

        for (int i = 0; i<5; i++) {
            lorry.schedule(new Parcel2(),1000, TimeUnit.MILLISECONDS);
        }
        lorry.shutdown(); //
    }

    static class Parcel2 implements Runnable {

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
