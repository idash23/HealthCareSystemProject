package edu.okcu.healthcaresystem.models;


import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.sql.*;

public class UserDB {
    public static SecurityProperties.User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:8808/HealthcaresystemApplication";
        String dbUser = "root";
        String dbPassword = "password";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        SecurityProperties.User user = null;

        if (result.next()) {
            user = new SecurityProperties.User();
            user.setName(result.getString("fullname"));
            //  user.setEmail(email);
        }

        connection.close();

        return user;
    }

}

