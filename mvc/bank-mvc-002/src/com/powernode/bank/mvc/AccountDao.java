package com.powernode.bank.mvc;

import com.powernode.bank.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * AccountDao 是负责 Account 数据的增删改查的。
 * 1. 什么是 DAO？
 *       Data Access Object（数据访问对象）
 * 2. DAO 实际上是一种设计模式，属于 JavaEE 的设计模式之一。（不是 23 种设计模式。）
 * 3. DAO 只负责数据库表的 CRUD，没有任何业务逻辑在里面。
 * 4. 没有任何业务逻辑，只负责表中数据增删改查的对象，有一个特殊的称谓：DAO 对象。
 * 5. 为什么叫做 AccountDao 呢？
 *       这是因为这个 DAO 是专门 t_act 这张表的。
 *       如果处理 t_student 表的话，可以叫做：StudentDao
 * 6. 一般情况下：一张表会对应一个 DAO 对象。
 * 7. DAO 中的方法名很固定了，一般都是：
 *      insert
 *      deleteByXxx
 *      update
 *      selectByXxx
 *      selectAll
 * */
public class AccountDao {
    /*
     * 插入账户信息
     * @param id 主键
     * @return
     * */
    public int insert(Account act) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into t_act(actno, balance) values(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, act.getActno());
            ps.setDouble(2, act.getBalance());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }

        return count;
    }

    /*
     * 根据主键删除账户
     * @param id 主键
     * @return
     * */
    public int deleteByActno(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from t_act where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    /*
     * 更新账户
     * @param act
     * @return
     * */
    public int update(Account act) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update t_act set balance = ?, actno = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, act.getBalance());
            ps.setString(2, act.getActno());
            ps.setLong(3, act.getId());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    /*
     * 根据账号查询用户
     * @param actno
     * return
     * */
    public Account selectByActno(String actno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account act = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "select id, balance from t_act where actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, actno);
            rs = ps.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                Double balance = rs.getDouble("balance");
                // 将结果集封装成 java 对象
                act = new Account();
                act.setId(id);
                act.setActno(actno);
                act.setBalance(balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return act;
    }

    /*
     * 获取所有的账户
     * @return
     * */
    public List<Account> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select id, balance from t_act";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // 取出数据
                Long id = rs.getLong("id");
                String actno = rs.getString("actno");
                Double balance = rs.getDouble("balance");
                // 封装对象
                /*
                Account account = new Account();
                account.setId(id);
                account.setActno(actno);
                account.setBalance(balance);
                */

                Account account = new Account(id, actno, balance);
                // 加到 List 集合
                list.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return list;
    }
}
