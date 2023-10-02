package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Util util;

    public UserDaoJDBCImpl() {
        util = new Util();
    }

    public void createUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS USERS\n" +
                    "(\n" + "ID BIGINT auto_increment,\n" +
                    "NAME VARCHAR(40) NOT NULL,\n" +
                    "LAST_NAME VARCHAR(40) NOT NULL,\n" +
                    "AGE INT NOT NULL,\n" +
                    "CONSTRAINT users_pk\n" +
                    "PRIMARY KEY (id)\n" + ");\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS USERS");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement prepareStatement = util.getConnection().prepareStatement("INSERT INTO USERS (NAME, LAST_NAME, AGE) VALUES(?, ?, ?)")) {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, lastName);
            prepareStatement.setInt(3, age);
            prepareStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("DELETE FROM USERS WHERE ID = ?")) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось удалить пользователя из БД! " + e.getMessage(), e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("SELECT * FROM USERS")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String last_name = resultSet.getString("LAST_NAME");
                int age = resultSet.getInt("AGE");

                User user = new User(id, name, last_name, (byte) age);
                userList.add(user);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить пользователей из БД! " + e.getMessage(), e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute("TRUNCATE TABLE USERS;");

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось удалить информацию о юзерах! " + e.getMessage(), e);
        }
    }
}
