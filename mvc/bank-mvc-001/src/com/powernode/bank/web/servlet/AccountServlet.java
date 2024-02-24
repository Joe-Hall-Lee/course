package com.powernode.bank.web.servlet;

import com.powernode.bank.exceptions.AppException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/*
 * 在不使用 MVC 架构模式的前提下，完成银行账户转账。
 * 分析这个程序存在哪些问题？
 * 缺点 1> 代码的复用性太差。（代码的重用性太差）
 * 导致缺点 1 的原因？
 *      因为没有进行“职能分工”，没有独立组件的概念，所以没有办法进行代码复用。代码和代码之间的耦合度太高，扩展力太差。
 * 缺点 2> 耦合度高，导致了代码很难扩展。
 * 缺点 3> 操作数据库的代码和业务逻辑混杂在一起，很容易出错。编写代码的时候容易出错，无法专注业务逻辑的编写。
 * 分析一下 AccountTransferServlet 它都负责了什么？
 * 1> 负责了数据处理
 * 2> 负责了核心的业务处理
 * 3> 负责了数据库表中数据的 CRUD 操作（Create【增】 Retrieve【查】 Update【改】 Delete【删】）
 * 4> 负责了页面的数据展示
 * ……
 *
 * 公司中一般都有很多员工，每个员工都各司其职，为什么要这样？
 *  保洁阿姨负责打扫卫生
 *  杜老师负责教学大纲的制定
 *  郭老师负责上课
 *  王老师负责学生就业
 * ……
 *
 * 我们公司只有一个员工，这个员工负责所有的事情。生病了。-->公司倒闭了。
 *
 * */

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取响应流对象
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取转账相关的信息
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        // 编写转账的业务逻辑代码，连接数据库，进行转账操作
        // 1. 转账之前要判断转出账户的余额是否充足
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/mvc";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
            // 开启事务（不再自动提交了，改为手动提交，业务完成之后再提交。）
            conn.setAutoCommit(false);
            // 获取预编译的数据库操作对象
            String sql1 = "select balance from t_act where actno = ?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, fromActno);

            // 执行 SQL 语句，返回结果集
            rs = ps.executeQuery();
            // 处理结果集
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (balance < money) {
                    // 余额不足（使用异常机制。）
                    throw new MoneyNotEnoughException("对不起，余额不足");

                }
                // 程序能够执行到这里，说明一定是充足的
                // 开始转账
                // act001 账户减去 10000
                // act002 账户加上 10000
                String sql2 = "update t_act set balance = balance - ? where actno = ?";
                ps2 = conn.prepareStatement(sql2);
                ps2.setDouble(1, money);
                ps2.setString(2, fromActno);

                int count = ps2.executeUpdate();

                // 模拟异常
                /*
                String s = null;
                s.toString();
                */

                String sql3 = "update t_act set balance = balance + ? where actno = ?";
                ps3 = conn.prepareStatement(sql3);
                ps3.setDouble(1, money);
                ps3.setString(2, toActno);

                // 累计
                count += ps3.executeUpdate();

                if (count != 2) {
                    throw new AppException("App 异常，请联系管理员");
                }

                // 手动提交异常
                conn.commit();
                out.print("转账成功");

            }
        } catch (Exception e) {
            // 保险起见，回滚事务。
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            // 异常处理，发生异常之后，你准备怎么做
            // e.printStackTrace();
            out.print(e.getMessage());
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ps2 != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ps3 != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
