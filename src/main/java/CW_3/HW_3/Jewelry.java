package CW_3.HW_3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Jewelry {
    int breakTime;
    public static final CountDownLatch START = new CountDownLatch(5);
    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 16; i++) {  //16 покупателей в день - тоже неплохо
            Buyer b = new Buyer(i, (int) (Math.random() * 8000));
            Thread buyer = new Thread(b);
            if (b.buyerID == 5) {
                System.out.println("Есть 4 покупателя. Мы открылись !");
                Thread.sleep(2000);
            }
            buyer.start();
            Thread.sleep(500);
        }
    }

    public static class Buyer implements Runnable {
        int buyerID;
        private int buyingTime;

        public Buyer(int buyerID, int buyingTime) {
            this.buyerID = buyerID;
            this.buyingTime = buyingTime;
        }

        @Override
        public void run() {
            try {
                SEMAPHORE.acquire();
                System.out.printf("Покупатель %d подошел к магазину\n", buyerID);
                START.countDown();
                START.await();
                Thread.sleep(500);
                System.out.printf("Покупатель %d зашел в магазин\n", buyerID);
                Thread.sleep(buyingTime);
                System.out.printf("Покупатель %d вышел из магазина\n", buyerID);
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
