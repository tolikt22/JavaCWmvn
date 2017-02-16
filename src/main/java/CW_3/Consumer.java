package CW_3;
public class Consumer implements Runnable {

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