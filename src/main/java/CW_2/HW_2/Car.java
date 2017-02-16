package CW_2.HW_2;

import java.io.Serializable;

public class Car implements Serializable {
    String name, model;
    private int power, speed, doors;
    private Gear gear;

    public Car(String name, String model, int power, int speed, int doors) {
        this.name = name;
        this.model = model;
        this.power = power;
        this.speed = speed;
        this.doors = doors;
        this.gear = new Gear(false, 5);
    }

    public class Gear implements Serializable {
        boolean isAuto = false;
        int gear = 5;

        public Gear(boolean isAuto, int gear) {
            this.isAuto = isAuto;
            if (gear <= 6) {
                this.gear = gear;
            } else {
                this.gear = 0;
                this.isAuto = true;
            }
        }

        @Override
        public String toString() {
            return "Gear{" +
                    "isAuto=" + isAuto +
                    ", gear=" + gear +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", speed=" + speed +
                ", doors=" + doors +
                ", gears=" + gear +
                '}';
    }
}
