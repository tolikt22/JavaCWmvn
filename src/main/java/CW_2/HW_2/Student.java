import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
    private String name;
    private int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static void printStudents(List<Student> students, int course) {
        List<Student> st = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCourse() == course) {
                st.add(students.get(i));
            }
        }
        Iterator iter = st.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static List<Student> createStudList() {
        List<Student> students = new ArrayList<>();
        Student st1 = new Student("Белик Анна", 1);
        Student st2 = new Student("Дубровская Татьяна", 2);
        Student st3 = new Student("Иовчева Анастасия", 4);
        Student st4 = new Student("Кравченко Елена", 3);
        Student st5 = new Student("Лисова Александра ", 2);
        Student st6 = new Student("Михайлова Дарья", 5);
        Student st7 = new Student("Пискарева Вероника", 2);
        Student st8 = new Student("Узор Михаил", 3);
        Student st9 = new Student("Фомичева Дарья", 5);
        Student st10 = new Student("Шмелев Леонид", 4);
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);
        students.add(st8);
        students.add(st9);
        students.add(st10);
        return students;
    }

    public static void main(String[] args) {
        printStudents(createStudList(), 2);
    }

    @Override
    public String toString() {
        return getName();
    }
}
