package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ØvelseITreningsøkt extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private ArrayList<String> øvelser = new ArrayList();
    private String date;
    private String name;


    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.OvelseiTreningsokt(idOvelse, idTreningsokt, Name) " +
                "VALUES ((SELECT idOvelse FROM Ovelse WHERE ovelseName = ? ),(SELECT idTreningsokt FROM DatDat.Treningsokt WHERE Date = ? ),?)";

        PreparedStatement ps = conn.prepareStatement(SQL);


        ps.setString(1, name);
        ps.setString(2, date);
        ps.setString(3, name);

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
