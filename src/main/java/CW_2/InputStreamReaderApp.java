package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Vitaliy конвертация строки введенной из стандартного ввода
 *
 */
public class InputStreamReaderApp {

    public String readLine() {
        String line = "";
        try {
            InputStream in = System.in;
            InputStreamReader charsIn = new InputStreamReader(in);//юайты в символы
//            InputStreamReader charsIn = new InputStreamReader(in, "UTF-8");
            BufferedReader buffedCharsIn = new BufferedReader(charsIn);
            System.out.println("Input line");
            line = buffedCharsIn.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) {
        InputStreamReaderApp app = new InputStreamReaderApp();
        System.out.println(app.readLine());
    }

}
