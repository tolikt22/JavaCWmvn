/*Задание 1
Нужно сохранить имена и фамилии всех своих сотрудников в ArrayList.
Каждый месяц, работник будет выбран случайным образом из этих записей, чтобы получить премию.*/

import java.util.ArrayList;
import java.util.List;

public class WorkerBonus {
    public static void main(String[] args) {
        List<String> workers = new ArrayList<>();
        workers.add("Петренко Петр");
        workers.add("Иванов Иван");
        workers.add("Сидоров Сидор");
        workers.add("Кокер  Джо");
        workers.add("Спилберг Степан");
        workers.add("Стюарт Мануэль");
        workers.add("Воркер Джон");
        System.out.println("Премию в этом месяце получает: " + workers.get((int)(Math.random()*6)));
    }
}
