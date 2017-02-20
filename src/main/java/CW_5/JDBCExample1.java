package CW_5;

import java.sql.*;

public class JDBCExample1 {
//    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/tolikt_data";
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "7777777a";

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement st = con.createStatement();
            Statement st1 = con.prepareStatement("SELECT  * FROM  car WHERE model=?");
            ResultSet rs = st.executeQuery("SELECT * FROM engine ORDER BY id DESC;");
//            ResultSet rs1 = st1.toString(1,'Anatolyii');
            while (rs.next()){
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString("power") + " ");
//                System.out.println(rs1.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}