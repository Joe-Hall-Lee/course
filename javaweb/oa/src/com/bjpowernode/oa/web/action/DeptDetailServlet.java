package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>部门详情</h1>");
        out.print("    <hr>");

        // 获取部门编号
        // /oa/dept/detail?deptno=30
        // 虽然是提交的 30，但是服务器获取的是“30”这个字符串。
        String deptno = request.getParameter("fdsafdsas");

        // 连接数据库，根据部门编号查询部门信息。
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            String sql = "select deptno, dname, loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            // 这个结果集一定只有一条记录。
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("        部门编号：" + deptno + " <br>");
                out.print("        部门名称：" + dname + " <br>");
                out.print("        部门位置：" + loc+ "<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        out.print("    <input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("</body>");
        out.print("</html>");
    }
}
