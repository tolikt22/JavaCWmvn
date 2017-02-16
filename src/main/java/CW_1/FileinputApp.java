package CW_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileinputApp {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try{
            fin = new FileInputStream(("c://SomeDir//Hello.txt"));
            System.out.print("Размер файла в байтах - " + fin.available());
            int i = 0;
            while (true) {
                System.out.println((char)i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (fin !=null) {
                    fin.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try(FileInputStream fin1 =  new FileInputStream("c://SomeDir//Hello.txt");
            FileInputStream fos = new FileInputStream("c://SomeDir//Hello1.txt")){
                fin = new FileInputStream(("c://SomeDir//Hello.txt"));
                System.out.print("Размер файла в байтах - " + fin.available());
                int i = 0;
                while (true) {
                    System.out.println((char)i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
