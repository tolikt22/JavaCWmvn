package CW_5.HW_5;// Created by tolik on 20.02.2017.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcCarService {
    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "7777777a";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Engine engine = new Engine(11755, 4200, 250);
//        Car car = new Car(50, "Studebecker", 1945, engine, 25000);

        System.out.println(Car.getCarById(4));
//        System.out.println(Engine.getEngineById(111755));
//        getCarById(3);
//        getEngineById(786254);
//        car.insertCar();
//        engine.insertEngine();
    }
    protected static Connection getDBConnection() throws ClassNotFoundException {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}
