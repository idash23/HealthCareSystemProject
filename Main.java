package edu.okcu.healthcaresystem;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("ocu-mysql-capstone.mysql.database.azure.com", " ocucapstone@ocu-mysql-capstone", "Gg21EL$#8w!K");

            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Health");
            while(rs.next()) {

                System.out.printf("%s \t%s \t%s\n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
