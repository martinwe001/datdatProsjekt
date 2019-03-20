package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Øvelse extends ActiveDomainObject {


    private String username = "bruker";
    private String password = "passord123";
    private String name;
    private int ovelsegruppe;
    private int number;


    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.Ovelse(ovelseName, IdOvelsegruppe) " +
                "VALUES (?, ?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, name);
        ps.setInt(2, ovelsegruppe);


        ps.executeUpdate();


        ps.close();
        conn.close();

    }

    @Override
    public void read(String name, String name1) throws SQLException {

        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "SELECT * FROM Ovelse ";


        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, number);


        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.name = rs.getString(2);
            this.ovelsegruppe = rs.getInt(3);
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOvelsegruppe() {
        return ovelsegruppe;
    }

    public void setOvelsegruppe(int ovelsesgruppe) {
        this.ovelsegruppe = ovelsesgruppe;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
