import CW_3.Storage;

public class Producer implements Runnable {

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

