package CW_3.HW_3;

import static java.lang.Thread.yield;

public class AppleStock {
    private static volatile int apples;

    public AppleStock(int apples) {
        this.apples = apples;
        System.out.println("На складе " + apples + " кг яблок");
    }

    public static void main(String[] args) throws InterruptedException {
        AppleStock stock = new AppleStock(120);
        new Supplier(stock, 100);
        new Shop(stock, 1, 20);
        new Shop(stock, 1, 20);
        new Shop(stock, 2, 20);
    }

    public synchronized void getApples(int require) {
        try {
            apples = apples - require;
            System.out.println("Текущий остаток: " + apples);
            if (apples == 0) {
                System.out.println("Ждем яблоки от поставщика...");
                Thread.currentThread().sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void putApples(int quantity) {
        try {
            if (apples < 30) {
                apples = apples + quantity;
                System.out.println("Текущий остаток: " + apples);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getRestOfApples() {
        return apples;
    }

    public static class Supplier implements Runnable {
        private AppleStock stock;
        private int quantity;

        public Supplier(AppleStock st, int quantity) {
            this.stock = st;
            this.quantity = quantity;
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Поставщик завозит на склад " + quantity + " кг яблок");
                    stock.putApples(quantity);
                    yield();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Shop implements Runnable {
        private AppleStock stock;
        private int shNumber, quantity;

        public Shop(AppleStock st, int n, int quantity) {
            this.stock = st;
            this.shNumber = n;
            this.quantity = quantity;
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int req = quantity;
                    if (req >= stock.getRestOfApples()) {
                        req = stock.getRestOfApples();
                    }
                    System.out.println("Магазин № " + shNumber + " забирает со склада " + req + " кг");
                    stock.getApples(req);
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
