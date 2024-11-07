package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import org.hibernate.Version;

import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.util.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Util.getConnection();
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 20);
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        userDao.saveUser("Name4", "LastName4", (byte) 38);

        userDao.removeUserById(1);
        List<User> a = userDao.getAllUsers();
        System.out.println(a + "ЖОПА");

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
