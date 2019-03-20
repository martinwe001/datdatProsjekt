package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Øvelsegruppe extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private String muskelgruppeNavn;
    private String name;
    private int number;


    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.Ovelsegruppe(Name, MuskelgruppeNavn) " +
                "VALUES (?, ?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, name);
        ps.setString(2, muskelgruppeNavn);

        ps.executeUpdate();

        ps.close();
        conn.close();

    }

    @Override
    public void read(String name, String name1) throws SQLException {

        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "SELECT * FROM Ovelse as o INNER JOIN Ovelsegruppe as og WHERE o.idOvelsegruppe = og.idOvelsegruppe AND o.idOvelsegruppe = ?";


        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, number);


        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.name = rs.getString(2);
            this.muskelgruppeNavn = rs.getString(4);
            System.out.println(toString());
        }


        ps.close();
        conn.close();

    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\t" + "Ovelsesgruppe: " + getNumber() + "\n";
    }

    @Override
    public void update() throws SQLException {

    }

    public String getMuskelgruppeNavn() {
        return muskelgruppeNavn;
    }

    public void setMuskelgruppeNavn(String muskelgruppeNavn) {
        this.muskelgruppeNavn = muskelgruppeNavn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
