package edu.okcu.healthcaresystem.models;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static java.lang.Class.forName;

public class myDB {


    public static void main(String[] args) {

        {
            String jdbcURL = "jdbc:mysql://ocu-mysql-capstone.mysql.database.azure.com";
            String dbUser =  "ocucapstone@ocu-mysql-capstone";
            String dbPassword =  "Gg21EL$#8w!K";


try {

      Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser,dbPassword);
                  System.out.println("Connection is sucesssfull to the database: " + jdbcURL);
                  String query = "select * from person";
                  Statement statement = connection.createStatement();
                  statement.executeQuery(query);


        } catch (ClassNotFoundException e) {
    e.printStackTrace();
        } catch (SQLException throwables) {
    throwables.printStackTrace();
        }


        }


    }

}