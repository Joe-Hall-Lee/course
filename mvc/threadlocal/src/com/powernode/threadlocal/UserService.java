package com.powernode.threadlocal;

public class UserService {

    private UserDao userDao = new UserDao();
    public void save() {
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
        userDao.insert();
    }
}
