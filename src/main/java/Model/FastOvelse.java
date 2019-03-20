package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FastOvelse extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private int kilo;
    private int set;



    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.FastOvelse(Kilo, Set) " +
                "VALUES (?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, kilo);
        ps.setInt(2, set);

        ps.executeUpdate();

        ps.close();
        conn.close();

    }

    @Override
    public void read(String name, String name1) throws SQLException {

    }

    @Override
    public void update() throws SQLException {

    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }
}
