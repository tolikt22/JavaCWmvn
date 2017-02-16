import CW_2.HW_2.Car;

import java.io.*;

public class SerializeCar {
    public static void main(String[] args) {
        Car car = new Car("Polo", "Volkswagen", 90, 160, 3);
        Car car1 = new Car("Baclajan", "Sedan", 70, 200, 5);

        serializeCar(car,car1);

        deserializeCar();
    }

    public static void serializeCar(Car car, Car car1) {
        try {
            FileOutputStream fos = new FileOutputStream("c://cars.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(car);
            oos.writeObject(car1);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeCar(){
        try {
            FileInputStream fis = new FileInputStream("cars.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                Car car = (Car) ois.readObject();
                Car car1 = (Car) ois.readObject();
                System.out.println(car.toString());
                System.out.println(car1.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
