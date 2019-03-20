package Misc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectTest {

    static protected Connection conn;

    public static void main(String[] args) {
        try {
            Properties p = new Properties();
            p.put("user", "bruker");
            p.put("password", "passord123");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatDat?allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", p);
            System.out.println("Success");


        } catch (Exception e) {
            throw new RuntimeException("Unable to connect", e);
        }




    }
}