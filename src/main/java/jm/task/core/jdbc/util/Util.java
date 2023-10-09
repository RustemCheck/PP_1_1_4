package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/bd_kata";
    private final String USERNAME = "root";
    private final String PASSWORD = "69myDONt";

    private Connection connection;

    private static SessionFactory sessionFactory;

    public Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
    public Util() {
    }
}
