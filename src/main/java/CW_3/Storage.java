package CW_3;

public class Storage {
    private int n;
    private boolean check = false;

    public static void main(String[] args) {
        Storage storage = new Storage();
        new Producer(storage);
        new Consumer(storage);
    }

    public synchronized int get() {
        while (!check) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException");
            }
        }
        System.out.println("Get - " + n);
        check = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (check) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException");
            }
        }
        this.n = n;
        check = true;
        System.out.println("Put - " + n);
        notify();
    }

    public static class Consumer implements Runnable {

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
            new Thread(this, "Consumer").start();
        }

        @Override
        public void run() {
            while (true) {
                storage.get();
            }
        }
    }

    public static class Producer implements Runnable {

        private Storage storage;

        public Producer(Storage s) {
            this.storage = s;
            new Thread(this, "Producer").start();
        }

        @Override
        public void run() {
            int i = 0;

            while (true) {
                storage.put(i++);
            }
        }
    }
}