package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FriOvelse extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private String description;



    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.FriOvelse(Description) " +
                "VALUES (?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, description);

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
}
