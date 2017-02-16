package CW_3.HW_3;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Auction {
    private static final CountDownLatch CARREADY = new CountDownLatch(6);
    private static final CountDownLatch BUYERREADY = new CountDownLatch(11);
    private static ArrayList<Buyer> price = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 6; i++) {
            Car c = new Car("Car" + i);
            Thread car = new Thread(c);
            car.start();
            Thread.sleep(250);
        }
        for (int i = 1; i < 11; i++) {
            int pr = (int) (Math.random() * 20000);
            Buyer buyer = new Buyer(i, pr);
            new Thread(buyer).start();
            price.add(buyer);
            Thread.sleep(250);
        }
        CARREADY.countDown();
        System.out.print("Все машины на месте, ");
        BUYERREADY.countDown();
        System.out.println("покупатели тоже, начинаем торги.");
        System.out.printf("На продажу выставлен автомобиль %d\n", 4);
        Thread.currentThread().sleep(2100);
        System.out.println("Победил покупатель__%d, предложивший максимальную цену: $" + bidding(price));
    }

    public static int bidding(ArrayList<Buyer> price) {
        int max = 0;
        for (Buyer b : price) {
            if (b.getPriceOffer()>max) max = b.getPriceOffer();
        }
        return max;
    }

    public static class Car implements Runnable {
        String model;

        public Car(String model) {
            this.model = model;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль %s заехал в салон\n", model);
                CARREADY.countDown();
                CARREADY.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Buyer implements Runnable {
        int number;
        int priceOffer;

        public Buyer(int number, int priceOffer) {
            this.number = number;
            this.priceOffer = priceOffer;
        }

        public int getPriceOffer() {
            return priceOffer;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Покупатель_%d зарегистрировался на аукционe\n", number);
                BUYERREADY.countDown();
                BUYERREADY.await();
                Thread.sleep(2000);
                System.out.printf("Покупатель_%d предлагает цену $ %d\n", number, priceOffer);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
