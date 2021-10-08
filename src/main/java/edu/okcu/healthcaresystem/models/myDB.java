package edu.okcu.healthcaresystem.models;


import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static java.lang.Class.forName;

public class myDB {
    private static Connection connectDatabase(){
        String jdbcURL = "jdbc:mysql://ocu-mysql-capstone.mysql.database.azure.com";
        String dbUser =  "ocucapstone@ocu-mysql-capstone";
        String dbPassword =  "Gg21EL$#8w!K";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Connection is successful to the database: " + jdbcURL);
            String query = "USE health;";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }//catch
        return connection;
    }//connectDatabase

    public static void signUp(String email, String password, String status, String DOB, String fName, String mName, String lName, String gender) {
        Connection conn = connectDatabase();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO User VALUES(0, ?, ?, 'saltToDefine', ?);");
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, status);
            stmt.executeQuery();

            PreparedStatement stmt1 = conn.prepareStatement("SELECT userID FROM user WHERE email = ?");
            stmt1.setString(1, email);
            ResultSet rs = stmt1.executeQuery();
            String userID = rs.getString("userID");

            PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO Patient VALUES(?, ?, ?, ?, ?, ?, ?, null , null ,null ,null\n" +
                    ",null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null);");
            stmt2.setString(1, userID);
            stmt2.setString(2, email);
            stmt2.setString(3, DOB);
            stmt2.setString(4, fName);
            stmt2.setString(5, mName);
            stmt2.setString(6, lName);
            stmt2.setString(7, gender);
            stmt2.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }//catch
    }

    public static void search(String toSearch) {
        Connection conn = connectDatabase();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Patient WHERE fname = ? OR lname = ?;");
            stmt.setString(1, toSearch);
            stmt.setString(2, toSearch);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String fName = rs.getString("fname");
                String mName = rs.getString("mname");
                String lName = rs.getString("lname");
                Date DOB = rs.getDate("DOB");
                String insurance = rs.getString("insurance");
                System.out.println(fName + ", " + mName + ", " + lName + ", " + DOB + ", " + insurance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }//catch
    }

    public static void addPatientInfo(String email, String height, String weight, String vision, String bloodPress,
                                     String pulseRate, String chickenpox,String diphtheria, String flu,String hepatitisA,
                                     String hepatitisB,String mmr, String tetanus,String polio, String surgery,String insurance) {
        Connection conn = connectDatabase();
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE Patient SET" +
                    "height=?,weight=?,vision=?,bloodPress=?,pulseRate=?,chickenpox=?,diphtheria=?," +
                    "flu=?,hepatitisA=?,hepatitisB=?,mmr=?,tetanus=?,polio=?,surgery=?,insurance=?" +
                    " WHERE email = ?;");
            statement.setString(1, height); statement.setString(2, weight);
            statement.setString(3, vision); statement.setString(4, bloodPress);
            statement.setString(5, pulseRate); statement.setString(6, chickenpox);
            statement.setString(7, diphtheria); statement.setString(8, flu);
            statement.setString(9, hepatitisA); statement.setString(10, hepatitisB);
            statement.setString(11, mmr); statement.setString(12, tetanus);
            statement.setString(13, polio); statement.setString(14, surgery);
            statement.setString(15, insurance);  statement.setString(16, email);
            statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }//catch
    }//main
}//myDB