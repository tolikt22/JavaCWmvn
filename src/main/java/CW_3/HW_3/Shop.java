package CW_3.HW_3;

import java.util.concurrent.CountDownLatch;

public class Shop {
    private static final CountDownLatch START = new CountDownLatch(4);
    private static boolean isPermitted = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(i+1, (int) (Math.random() * 1000 + 500))).start();
            Thread.sleep(1000);
        }

        while (START.getCount() > 3) {
            Thread.sleep(100);
        }
        if(isPermitted) {
            System.out.println("Все собрались, можно заходить");
            Thread.sleep(1000);
            START.countDown();
        }
    }

    public static class Consumer implements Runnable {
        private int consumNumber;
        private volatile int consumShopTime = 2000;

        public Consumer(int consumNumber, int consumShopTime) {
            this.consumNumber = consumNumber;
            this.consumShopTime = consumShopTime;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Покупатель №%d подошел к магазину\n", consumNumber);
                START.countDown();
                START.await();
                System.out.printf("Покупатель №%d вошел в магазин\n", consumNumber);
                Thread.sleep(consumShopTime);
                System.out.printf("Покупатель №%d вышел из магазина\n", consumNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
