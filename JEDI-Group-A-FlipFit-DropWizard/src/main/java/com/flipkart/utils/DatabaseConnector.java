package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit", "root", "yail5Eix!@#%");
                return con;
            }
            catch (Exception e) {
                System.out.println(e);
                return null;
            }
    }

    public static boolean isValid() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
