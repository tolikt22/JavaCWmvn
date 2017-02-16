package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Vitaliy
 */
public class FileInputAppWithResource {

    public static void main(String[] args) {

        try (FileInputStream fin = new FileInputStream("C://SomeDir//Hello.txt")) {
            int i;
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
