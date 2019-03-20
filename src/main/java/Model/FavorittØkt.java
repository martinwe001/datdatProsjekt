package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FavorittØkt extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private String name;
    private String description;
    private int økt;


    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.Favorittokt(Name, Description, idTreningsokt) " +
                "VALUES (?, ?, ?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, name);
        ps.setString(2, description);
        ps.setInt(3, økt);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setØkt(int økt) {
        this.økt = økt;
    }
}
