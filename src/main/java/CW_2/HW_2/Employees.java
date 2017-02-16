package CW_2.HW_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employees {
    public static void main(String[] args) {
        System.out.println(getEmployee(4, makeMap()));
    }

    public static Map<Integer, String> makeMap() {
        HashMap<Integer, String> employ = new HashMap();
        employ.put(1, "Адамович Татьяна");
        employ.put(2, "Андреева Регина");
        employ.put(3, "Жилин Игор");
        employ.put(4, "Зиновьев Виктор");
        employ.put(5, "Иванова Алёна");
        employ.put(6, "Филаретов Всеволод");
        employ.put(7, "Хоров Евгений");
        employ.put(8, "Цинман Леонид");
        return employ;
    }

    public static String getEmployee(int i, Map empl) {
        String name = "";
        Iterator iter = empl.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if (pair.getKey().equals(i)) {
                name = pair.getValue().toString();
            }
        }
        return name;
    }
}
