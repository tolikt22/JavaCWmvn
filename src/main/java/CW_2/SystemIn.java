package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author Vitaliy
 */
public class SystemIn {

    public void read() {
        try {
            int val;
            while ((val = System.in.read()) != -1) {
                System.out.println((byte) val);
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        SystemIn in = new SystemIn();
        in.read();
    }

}
