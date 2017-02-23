package CW_5.HW_5;

import java.sql.*;
import java.util.Set;

import static CW_5.HW_5.JdbcCarService.*;

public class Engine {
    int id, displacement, power;
    Set<Car> cars;

    public Engine(int id, int displacement, int power) throws ClassNotFoundException {
        this.id = id;
        this.displacement = displacement;
        this.power = power;
        this.cars = getCars(id);
    }

    @Override
    public String toString() {
        return "((Engine id=" + id +
                ", displacement=" + displacement +
                ", power=" + power +
                ", cars=" + cars +
                "))";
    }

    public static Engine getEngineById(int id) throws ClassNotFoundException {
        String searchStr = "SELECT * FROM engine WHERE id = " + id;
        Engine engine = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            PreparedStatement st = con.prepareStatement(searchStr);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                engine = new Engine(id, res.getInt(2), res.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engine;
    }

    public static void insertEngine() throws ClassNotFoundException, SQLException {
        String intstString = "INSERT INTO engine(id,\"displacement \",power) VALUES (111755,4200,250);";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement prst = con.prepareStatement(intstString);
        prst.execute();
    }

    public static Set<Car> getCars(int id) throws ClassNotFoundException {
        Car car;
        Set<Car> cars = null;
        String carWithEngineNumber = "SELECT * FROM car INNER JOIN engine ON car.id_engine = engine.id AND engine.id=" + id + ";";
        Connection con = JdbcCarService.getDBConnection();
        try {
            PreparedStatement st = con.prepareStatement(carWithEngineNumber);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                car = new Car(res.getInt(0),res.getString(1),res.getInt(2),res.getInt(3),Engine.getEngineById(res.getInt(3)));
                System.out.println(car);
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
