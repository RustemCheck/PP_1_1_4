package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/bd_kata";
    private final String USERNAME = "root";
    private final String PASSWORD = "69myDONt";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
