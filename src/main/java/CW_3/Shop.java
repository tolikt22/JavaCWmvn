import java.util.concurrent.CountDownLatch;

public class Shop {
    private static final CountDownLatch START = new CountDownLatch(3);
    private static final int shoppingTime = 5000;
    private boolean isTime = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }

        while (START.getCount() > 3)
            System.out.println("Менеджер разрешает запуск !");
            Thread.sleep(100);
    }
    public static class Consumer implements Runnable{
        private int consumNumber;
        private int consumShopTime;

        public Consumer(int consumNumber, int consumShopTime) {
            this.consumNumber = consumNumber;
            this.consumShopTime = consumShopTime;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Покупатель №%d зашел в магазин\n", consumNumber);
                START.countDown();
                START.await();
                Thread.sleep(3000 / consumShopTime);
                System.out.printf("Покупатель №%d вышел из магазина\n", consumNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
