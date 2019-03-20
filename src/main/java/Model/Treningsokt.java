package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Treningsokt extends ActiveDomainObject {

    private String username = "bruker";
    private String password = "passord123";
    private String date;
    private int time;
    private int length;
    private int personalShape;
    private int performance;
    private String note;
    private String query;
    private String ovelseid;
    private String name;
    private int number;
    private String ovelser = "";




    @Override
    public void create() throws SQLException {
        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "INSERT INTO DatDat.Treningsokt(Date, Time, Length, PersonalShape, Performance, Note) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, date);
        ps.setInt(2, time);
        ps.setInt(3, length);
        ps.setInt(4, personalShape);
        ps.setInt(5, performance);
        ps.setString(6, note);


        ps.executeUpdate();

        ps.close();
        conn.close();

    }

    @Override
    public void read(String query, String query1) throws SQLException {

        Connection conn = ActiveDomainObject.getConnection(this.username, this.password);

        String SQL = "SELECT * FROM DatDat.Treningsokt LIMIT ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, getNumber());

        ResultSet rs = ps.executeQuery();



        while(rs.next()){
            this.date = rs.getString(2);
            this.time = rs.getInt(3);
            this.length = rs.getInt(4);
            this.personalShape = rs.getInt(5);
            this.performance = rs.getInt(6);
            this.note = rs.getString(7);
            System.out.println(toString());

        }



        ps.close();
        conn.close();


    }

    @Override
    public String toString(){
        return "Date: " + getDate()+ "\t" +
                "Time: " + getTime() + "\t" +
                "Length: " + getLength() + "\t" +
                "Personal Shape: " + getPersonalShape() + "\t" +
                "Performance: " + getPerformance() + "\t" +
                "Note: " + getNote() + "\n";

    }



    @Override
    public void update() throws SQLException {

    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersonalShape() {
        return personalShape;
    }

    public void setPersonalShape(int personalShape) {
        this.personalShape = personalShape;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOvelseid() {
        return ovelseid;
    }

    public void setOvelseid(String ovelseid) {
        this.ovelseid = ovelseid;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public String getOvelser() {
        return ovelser;
    }

    public void setOvelser(String ovelser) {
        this.ovelser = ovelser;
    }
}
