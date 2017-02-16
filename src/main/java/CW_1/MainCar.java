package CW_1;

/**
 * Created by java-2-06 on 23.01.2017.
 */
public class MainCar {
    public static void main(String[] args) {

        Car c1 =  new Bmw();
        Car c2 = new Audi();
        c1.drive();
        System.out.println();
        c2.drive();

    }
}
