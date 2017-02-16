package CW_4.HW_4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Delivery3 {
    static int mAtoBTime = 3000;
    static int mBtoATime = 1000;
    static volatile int parcInA = 1;
    static volatile int parcInB = 10;

    public static void main(String[] args) {
//        ScheduledExecutorService lorryA = Executors.newScheduledThreadPool(5);
//        ScheduledExecutorService lorryB = Executors.newScheduledThreadPool(10);
//        lorryA.scheduleWithFixedDelay(new ParcelAtoB(), 0, 100, TimeUnit.MILLISECONDS);
//        lorryB.scheduleWithFixedDelay(new ParcelBtoA(), 0, 100, TimeUnit.MILLISECONDS);
        ExecutorService lorryA = Executors.newFixedThreadPool(5);
        ExecutorService lorryB = Executors.newFixedThreadPool(10);

        while (true) {
            lorryA.submit(new ParcelAtoB());
            lorryB.submit(new ParcelBtoA());
        }
    }
    static class ParcelAtoB implements Runnable {
        @Override
        public void run() {
            try {
                while (parcInA == 0) wait();
                parcInA--;
                Thread.sleep(mAtoBTime);
                parcInB++;
                System.out.println(getClass().getName() + "  приехал     из А  в  В   " + new Date().getTime() / 100);
                System.out.println("A= " + parcInA + "  B= " + parcInB);
                while (parcInB == 0) wait();
                parcInB--;
                Thread.sleep(mBtoATime);
                parcInA++;
                System.out.println(getClass().getName() + "  возвратился из В  в  А   " + new Date().getTime() / 100);
                System.out.println("A= " + parcInA + "  B= " + parcInB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ParcelBtoA implements Runnable {
        @Override
        public void run() {
            try {
                while (parcInB == 0) wait();
                parcInB--;
                Thread.sleep(mBtoATime);
                parcInA++;
                System.out.println(getClass().getName() + "  приехал     из B  в  A   " + new Date().getTime() / 100);
                System.out.println("A= " + parcInA + "  B= " + parcInB);
                while (parcInA == 0) wait();
                parcInA--;
                Thread.sleep(mAtoBTime);
                parcInB++;
                System.out.println(getClass().getName() + "  возвратился из В  в  А   " + new Date().getTime() / 100);
                System.out.println("A= " + parcInA + "   B= " + parcInB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
