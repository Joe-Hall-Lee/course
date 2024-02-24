package com.powernode.threadlocal;

public class DBUtil {

    // 静态变量特点：类加载时再执行，并且只执行一次。
    // 全局的大 Map 集合
    private static MyThreadLocal<Connection> local = new MyThreadLocal<>();

    /*
    * 每一次都调用这个方法来获取 Connection 对象
    * @return
    * */
    public static Connection getConnection() {
        Connection connection = local.get();
        if (connection == null) {
            // 第一次调用 getConnection() 方法的时候，connection 一定是空的。
            // 空的就 new 一次。
            connection = new Connection();
            // 将 new 的 Connection 对象绑定到大 Map 集合中。
            local.set(connection);
        }
        return connection;
    }
}
