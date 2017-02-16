package CW_3.HW_3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Football {
    private static final CountDownLatch START = new CountDownLatch(10);
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 1; i < 11; i++) {
                new Thread(new Player(i)).start();
                Thread.sleep(100);
            }

            while (START.getCount() > 8) {
                Thread.sleep(100);
            }
            System.out.println("Все собрались, смотрят на небо...");
            boolean isNotRainy = random.nextBoolean();
            if(isNotRainy) {
                System.out.println("Дождя нет, прекрасная погода !");
                Thread.sleep(1000);
                System.out.println("Играем !");
                Thread.sleep(1000);
                START.countDown();
            }else {
                System.out.println("Идет дождь, игра отменяется. Собираемся через неделю");
            }
            for (int i = 1; i< 8;i++) {
                System.out.print(i+" ");
                Thread.sleep(10000/7);
            }
            System.out.println();
        }
    }

    public static class Player implements Runnable {
        private int playerNumber;

        public Player(int playerNumber) {
            this.playerNumber = playerNumber;
        }
        @Override
        public void run() {
            try {
                System.out.printf("Игрок №%d пришел на стадион\n", playerNumber);
                START.countDown();
                START.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
