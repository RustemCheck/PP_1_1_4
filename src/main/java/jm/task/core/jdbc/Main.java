package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Rustem", "Zinnatullin", (byte) 25);
        userDao.saveUser("Artur", "Karpov", (byte) 28);
        userDao.saveUser("Maksim", "Surkov", (byte) 19);
        userDao.saveUser("Elena", "Orlova", (byte) 34);

        userDao.getAllUsers();
        userDao.removeUserById(3);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
