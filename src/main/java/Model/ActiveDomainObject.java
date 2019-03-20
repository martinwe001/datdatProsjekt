package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.System.exit;


public abstract class ActiveDomainObject {


    public static Connection getConnection(String username, String password) {
        Connection conn = null;
        Properties props = new Properties();
        props.put("user", username);
        props.put("password", password);
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatDat" +
                    "?allowPublicKeyRetrieval=true" +
                    "&useUnicode=true" +
                    "&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false" +
                    "&serverTimezone=UTC", props);
        } catch (SQLException e) {
            System.err.println("Klarte ikke koble til databasen");
            e.printStackTrace();
            exit(1);
        }
        return conn;
    }

    /**
     * Inserts current object to database
     */
    public abstract void create() throws SQLException;

    /**
     * Loads object from database
     *
     *
     */
    public abstract void read(String name, String name1) throws SQLException;

    /**
     * Updates database with current object
     */
    public abstract void update() throws SQLException;

    @Override
    public String toString() {
        return super.toString() ;
    }
}