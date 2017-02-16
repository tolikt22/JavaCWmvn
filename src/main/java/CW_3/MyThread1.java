package CW_3;
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("First thread");
            try {
                Thread.sleep(1000);
//                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread0 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Second thread");
                try {
                    Thread.sleep(1000);
//                    yield();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable myThread1 = new MyThread1();
        Thread myThread1_ = new Thread(myThread1);
        MyThread0 myThread = new MyThread0();

        myThread.setPriority(1);
        myThread1_.setPriority(5);

        myThread1_.start();
        myThread.start();
    }
}
