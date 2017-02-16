package CW_3;
public class PrintService {
    public static void main(String[] args) {
        PrintService service = new PrintService();
        new PrintThread(service, "From thread1");
        new PrintThread(service, "From thread2");
        new PrintThread(service, "From thread3");
    }

    public void print(String msg) {
        try {
            System.out.print("[" + msg);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }

}
