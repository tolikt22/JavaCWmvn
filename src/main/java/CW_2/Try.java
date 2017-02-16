package CW_2;

import java.sql.SQLException;

/**
 * Created by java-2-06 on 29.01.2017.
 */
public class Try {
    public static void main(String[] args) throws SQLException {
//        try {
//            System.out.println("");
//        } catch (RuntimeException re ||SQLException re) {
//            re.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            System.out.println("In try");
//            System.exit(0);
            throw new SQLException();
        } catch (RuntimeException e) {

        } finally {
            System.out.print("finally");
        }
        System.out.println("After");
    }
}
