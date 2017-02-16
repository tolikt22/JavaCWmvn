package CW_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * @author Vitaliy
 */
public class FileOutputPrint {

    private void saveToFile() {
        String text = "Привет мир!"; // строка для записи
        try (FileOutputStream fos = new FileOutputStream("C://SomeDir//Hello.txt");
             PrintStream printStream = new PrintStream(fos)) {
            printStream.println(text);
            System.out.println("Запись в файл произведена");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private void saveToFileDif() {
        String s1 = "Привет мир!";
        String s2 = "Hello World!";
        try (PrintStream printStream = new PrintStream("C://SomeDir//Hello.txt")) {
            printStream.println(s1);
            int i = 2;
            printStream.printf("Квадрат числа %d равен %d \n", i, i * i);
            byte[] s2_toBytes = s2.getBytes();
            printStream.write(s2_toBytes);
            printStream.print("Конец");
            System.out.println("Запись в файл произведена");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        FileOutputPrint fop = new FileOutputPrint();
        fop.saveToFile();
        fop.saveToFileDif();
    }
}
