package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Vitaliy
 */
public class FileInputOutputApp {

    public static void main(String[] args) {

       try(FileInputStream fin=new FileInputStream("C://SomeDir//Hello.txt");
                FileOutputStream fos=new FileOutputStream("C://SomeDir//Hello_new.txt"))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
}
