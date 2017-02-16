package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Vitaliy
 */
public class FileOutputBufferedApp {

    public static void main(String[] args) {

        String text = "Hello world!!!!"; // строка для записи
        try (FileOutputStream fos = new FileOutputStream("C://SomeDir//Hello.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
