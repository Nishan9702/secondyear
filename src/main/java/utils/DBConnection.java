package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";

    // Database username
    private static final String DB_USER = "root";

    // Database password
    private static final String DB_PASSWORD = "12345";


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
