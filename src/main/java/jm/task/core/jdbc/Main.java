package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoHibernateImpl();

//        userDao.createUsersTable();
        userDao.dropUsersTable();

        userDao.saveUser("Test", "Test", (byte) 31);
//        userDao.getAllUsers();
//        userDao.saveUser("Artur", "Karpov", (byte) 17);
//        userDao.saveUser("Nikita", "Popov", (byte) 29);
//        userDao.saveUser("Bob", "Skayler", (byte) 19);
//        userDao.saveUser("Zuar", "Tregulov", (byte) 23);

        //userDao.removeUserById(3);
//        userDao.getAllUsers();
    }
}
