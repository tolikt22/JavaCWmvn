package CW_1.HW_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by tolik on 22.01.2017.
 */
/*Задача будильник: пользователь вводит число от 0 до 24, если число в диапазоне
от 8 до 21 - вывести на экран сообщение “Привет”, если любое другое, то “Абонент отдыхает”.*/

public class Alarm {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число от 0 до 24");
        int time = Integer.parseInt(reader.readLine());
        if (time >= 8 && time <= 21) {
            System.out.println("Привет");
        } else if (time >= 0 && time <= 24) {
            System.out.println("Абонент отдыхает");
        } else {
            System.out.println("Неверное число");
        }
    }
}
