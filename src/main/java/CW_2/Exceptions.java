package CW_2;

/**
 * Created by java-2-06 on 29.01.2017.
 */
public class Exceptions {

    public static class ChainedException {
        private static void process() {
            //create Exception
            NullPointerException e = new NullPointerException("upper level");
            //add cause
            e.initCause(new ArithmeticException("cause"));
            throw e;
        }

        public static void main(String[] args) {
            try {
                process();
            } catch (NullPointerException e) {
                System.out.print("Catched");;
            }
        }
    }
}
