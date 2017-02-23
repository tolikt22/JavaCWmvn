package CW_5.HW_5;

import java.sql.*;

import static CW_5.HW_5.JdbcCarService.*;

public class Car {
    int id, make, price;
    String model;
    Engine engine;

    public Car(int id, String model, int make,int price, Engine engine) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
        this.engine = engine;
    }

    public static Car getCarById(int id) throws ClassNotFoundException {
        String searchStr = "SELECT * FROM car WHERE id = " + id;
        Car car = null;
        Connection con = JdbcCarService.getDBConnection();
        try {
            PreparedStatement st = con.prepareStatement(searchStr);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                car = new Car(id, res.getString(1), res.getInt(2), res.getInt(4), Engine.getEngineById(res.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
    void insertCar() throws ClassNotFoundException {
        String insString = "INSERT INTO car (id,model, make, id_engine, price) VALUES (" + this.id +",'"+model+"'"+","+make +","+engine +","+price+");";
        System.out.println(insString);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            PreparedStatement pst = con.prepareStatement(insString);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Car :" +
                "id= " + id +
                ", модель='" + model + '\'' +
                ", год= " + make +
                ", двигатель=" + engine +
                ", цена=" + price +
                '}';
    }
}
