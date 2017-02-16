package CW_3;

public class Test {

    public static void main(String[] args) {
        PrintService service = new PrintService();
        new PrintThread(service, "From thread1");
        new PrintThread(service, "From thread2");
        new PrintThread(service, "From thread3");
    }
}