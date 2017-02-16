package CW_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service = Executors.newFixedThreadPool(15);
        ExecutorService service = Executors.newCachedThreadPool();
        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(2);
            service1.submit(new Threadd());
        service1.schedule(new Threadd(), 1000, TimeUnit.MILLISECONDS);
        service1.scheduleWithFixedDelay(new Threadd(),2000,3000,TimeUnit.MILLISECONDS);
        service1.scheduleWithFixedDelay(new Threadd(),2000,3000,TimeUnit.MILLISECONDS);

    }
    static class Threadd implements Runnable {


        @Override
        public void run() {
            System.out.println("Enter");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Out");
        }
    }
}


