package CW_3.HW_3;

public class FourThreads {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThreads(), "Первый поток");
        Thread t2 = new Thread(new MyThreads(), "Второй поток");
        Thread t3 = new Thread(new MyThreads(), "Третий поток");
        Thread t4 = new Thread(new MyThreads(), "Четвертый поток");

        t1.start();

        try {
            t1.join();//после выполнения 1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start(); //запускаем 2 и 3
        t3.start();

        try {
            t3.join();
            t2.join();//после выполн. 2 и 3
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start(); //запуск 4
    }

    static class MyThreads implements Runnable {
        @Override
        public void run() {
            System.out.println("Выполняется ... " + Thread.currentThread().getName());
            try {
                Thread.sleep((int) (Math.random() * 6000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Отработал - " + Thread.currentThread().getName());
        }
    }
}
